package spring.security.rest.api.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import spring.security.rest.api.entity.ProductDetails;

/**
 * Customer details exposing as a service. This is secured by spring role base
 * security. This service is only for ROLE_ADMIN
 * 
 * @author OptimumAlgorithms
 * 
 */
@Controller
@RequestMapping(value = "/product", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
@Secured("ROLE_ADMIN")
public class ProductService {

	private Map<Integer, ProductDetails> productCache = null;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public ProductService() {
		super();
	}

	/**
	 * Init method to initialize the product cache with some default values
	 */
	@PostConstruct
	private void init() {
		productCache = new HashMap<Integer, ProductDetails>();
		productCache.put(101, new ProductDetails(101, "BackPack"));
		productCache.put(102, new ProductDetails(102, "LapTop"));
		productCache.put(103, new ProductDetails(103, "HDD"));
		productCache.put(104, new ProductDetails(104, "keyBoard"));
		productCache.put(105, new ProductDetails(105, "RAM"));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ProductDetails findById(@PathVariable("id") final int id,
			final UriComponentsBuilder uriBuilder,
			final HttpServletResponse response) {
		return productCache.get(id);
	}

	@RequestMapping(method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<Integer, ProductDetails> findAll() {
		return productCache;
	}

}