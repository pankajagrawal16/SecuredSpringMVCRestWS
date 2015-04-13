package spring.security.rest.api.entity;

import java.io.Serializable;

/**
 * Customer details persistence entity
 * 
 * @author OptimumAlgorithms
 * 
 */
public class ProductDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	private long productId;
	private String productName;

	public ProductDetails() {
		super();
	}

	public ProductDetails(long productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
