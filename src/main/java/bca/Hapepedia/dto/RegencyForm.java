package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class RegencyForm {

	
	@NotEmpty(message = "Description is required")
	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    
    
}
