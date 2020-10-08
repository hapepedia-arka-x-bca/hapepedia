package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class ProductImageForm {
	@NotEmpty(message = "File is required.")
	private String file;
	
	@NotEmpty(message = "Product is required.")
	private Long productId;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}