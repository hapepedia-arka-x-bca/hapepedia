package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {
	private Long id;

	@NotEmpty(message = "Product Name is required.")
	private String name;

	@NotNull(message = "Brand is required.")
	private Long brandId;

	@NotNull(message = "Category is required.")
	private Long categoryId;

	@NotEmpty(message = "Specification is required.")
	private String specification;

	@NotNull(message = "Weight is required.")
	private double weight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

}
