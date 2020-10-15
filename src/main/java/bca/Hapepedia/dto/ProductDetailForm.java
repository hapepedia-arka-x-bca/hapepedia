package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDetailForm {
	private Long id;

	// @NotEmpty(message = "Product is required.")
	private Long product;

	// @NotEmpty(message = "Product Color is required.")
	private Long color;

	// @NotEmpty(message = "Product Varian is required.")
	private Integer varian;

	// @NotEmpty(message = "Product Stock is required.")
	private Long Stock;

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

	public Integer getVarian() {
		return varian;
	}

	public void setVarian(Integer varian) {
		this.varian = varian;
	}

	public Long getStock() {
		return Stock;
	}

	public void setStock(Long stock) {
		Stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
