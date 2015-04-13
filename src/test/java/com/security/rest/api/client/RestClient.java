package com.security.rest.api.client;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import spring.security.rest.api.entity.ProductDetails;

/**
 * A Spring RestTemplate based webService client
 * 
 * @author OptimumAlgorithms
 *
 */
public class RestClient {
	public static void main(String[] args) throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		// Converter used to map POJO's to JSON
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		messageConverters.add(new FormHttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);

		// Handle cookies
		CookieHandler.setDefault(new CookieManager(null,
				CookiePolicy.ACCEPT_ALL));

		// Create headers with authentication data
		HttpHeaders httpHeaders = createHeaders("admin@gmail.com", "password");

		// URL to hit
		String url = "http://localhost:8080/SpringMVCSecuredRWS/api/product/101";

		// Fetch the response
		ResponseEntity<ProductDetails> response = restTemplate.exchange(url,
				HttpMethod.GET, new HttpEntity<Object>(httpHeaders),
				ProductDetails.class);

		ProductDetails productDetails = response.getBody();
		System.out.println(productDetails.getProductId());
		System.out.println(productDetails.getProductName());

		url = "http://localhost:8080/SpringMVCSecuredRWS/api/product";

		// Fetch the response
		ResponseEntity<Map> allProducts = restTemplate.exchange(url,
				HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Map.class);
		System.out.println(allProducts);

	}

	/**
	 * A utility method to create headers. This also specifies the response type
	 * and content Type
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@SuppressWarnings("all")
	private static HttpHeaders createHeaders(final String username,
			final String password) {
		HttpHeaders headers = new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset
						.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(new ArrayList<MediaType>() {
			{
				add(MediaType.APPLICATION_JSON);
			}
		});

		return headers;
	}
}