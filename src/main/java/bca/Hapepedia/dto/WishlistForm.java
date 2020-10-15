package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class WishlistForm {
	private Long id;
	
	private Long customerId;
	
	private Long productDetailId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(Long productDetailId) {
		this.productDetailId = productDetailId;
	}

}
