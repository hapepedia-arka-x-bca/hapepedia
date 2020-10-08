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
import bca.Hapepedia.entity.Admin;
import bca.Hapepedia.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody LoginForm loginForm){
        ResponseData response = new ResponseData();
		try {
            Admin admin = adminService.findByEmail(loginForm.getEmail());

            if(admin != null) {
                if(admin.getPassword().equals(loginForm.getPassword())){
                    String baseStr = admin.getEmail() + ":" + admin.getPassword();
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
    public ResponseEntity<ResponseData> findAllAdmin(){
        ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Admin loaded");
			response.setPayload(adminService.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load admin: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

    
    
    

}
