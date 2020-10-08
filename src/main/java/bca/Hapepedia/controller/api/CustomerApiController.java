package bca.Hapepedia.controller.api;

import java.util.Base64;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.LoginForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.services.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody LoginForm loginForm){
        ResponseData response = new ResponseData();
		try {
            Customer customer = customerService.findByEmail(loginForm.getEmail());

            if(customer != null) {
                if(customer.getPassword().equals(loginForm.getPassword())){
                    String baseStr = customer.getEmail() + ":" + customer.getPassword();
                    String token = Base64.getEncoder().encodeToString(baseStr.getBytes());
                    response.setPayload(token);				
                    response.setStatus(true);
                    response.getMessages().add("Login success");
                    return ResponseEntity.ok(response);
                }
                else {
                    response.setStatus(false);
                    response.getMessages().add("Sorry, Wrong Password");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                }
                
            }else {
                response.setStatus(false);
                response.getMessages().add("Sorry, Email doesn't exist");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
                
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Errors: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        
    }
    
    @GetMapping
    public ResponseEntity<ResponseData> findAllCustomer(){
        ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Customer loaded");
			response.setPayload(customerService.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load customer: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

    
    
    

}
