package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;


public class PaymentMethodForm {

    private Long id;
	
	@NotEmpty(message = "Description is required")
	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
    
    
}
