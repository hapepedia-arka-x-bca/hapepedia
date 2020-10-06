package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class BrandForm {
	
	private Long id;
	
	@NotEmpty(message = "Brand Name is required.")
	private String name;

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
	
}
