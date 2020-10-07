package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

import bca.Hapepedia.entity.Color;
import bca.Hapepedia.entity.Product;
import bca.Hapepedia.entity.Varian;

public class ProductDetailForm {
	private Long id;

	@NotEmpty(message = "Product is required.")
	private Product product;

	@NotEmpty(message = "Product Color is required.")
	private Color color;

	@NotEmpty(message = "Product Varian is required.")
	private Varian varian;
	
	@NotEmpty(message = "Product Stock is required.")
	private Long Stock;
	
	@NotEmpty(message = "Product Price is required.")
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Varian getVarian() {
		return varian;
	}

	public void setVarian(Varian varian) {
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
