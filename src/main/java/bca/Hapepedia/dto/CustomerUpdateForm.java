package bca.Hapepedia.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class CustomerUpdateForm {

    private Long id;
    
	private String password;
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "Name is required")
    private String name;
    
    private String gender;

    private Long phone_number;

	private Date birth_date;
    

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
