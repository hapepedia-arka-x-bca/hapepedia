package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AdminForm {

    @NotEmpty(message="Code is required")
	@Size(min = 8, message="Password required 8 character")
	private String password;
	
	@NotEmpty(message = "Title is required")
	private String email;
	
	@NotEmpty(message = "Description is required")
	private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    
    
}
