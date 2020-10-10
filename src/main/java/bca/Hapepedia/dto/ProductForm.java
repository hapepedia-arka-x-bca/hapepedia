package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {
	private Long id;

	@NotEmpty(message = "Product Name is required.")
	private String name;
	
	@NotNull(message = "Brand is required.")
	private Long brand_id;
	
	@NotNull(message = "Category is required.")
	private Long id_category;
	
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


	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
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

	public Long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}
	
}
