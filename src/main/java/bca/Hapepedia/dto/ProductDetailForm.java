package bca.Hapepedia.dto;

public class ProductDetailForm {
	private Long id;

	// @NotEmpty(message = "Product is required.")
	private Long product;

	// @NotEmpty(message = "Product Color is required.")
	private Long color;

	// @NotEmpty(message = "Product Varian is required.")
	private Long varian;

	// @NotEmpty(message = "Product Stock is required.")
	private Long stock;

	// @NotNull(message = "Product Price is required.")
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Long getColor() {
		return color;
	}

	public void setColor(Long color) {
		this.color = color;
	}

	public Long getVarian() {
		return varian;
	}

	public void setVarian(Long varian) {
		this.varian = varian;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
