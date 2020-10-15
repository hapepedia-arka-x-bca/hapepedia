package bca.Hapepedia.dto;

import javax.validation.constraints.NotNull;

public class DeleteForm {
	@NotNull(message = "Id is required.")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
