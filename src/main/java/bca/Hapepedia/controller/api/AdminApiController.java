package bca.Hapepedia.controller.api;

import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.AdminForm;
import bca.Hapepedia.dto.LoginForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.dto.ResponseLogin;
import bca.Hapepedia.entity.Admin;
import bca.Hapepedia.entity.Product;
import bca.Hapepedia.services.AdminService;
import bca.Hapepedia.services.ProductService;
import bca.Hapepedia.utility.MD5Generator;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService customerService;

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody LoginForm loginForm) {
        ResponseData response = new ResponseData();
        try {
            Admin admin = adminService.findByEmail(loginForm.getEmail());

            if (admin != null) {
                if (admin.getPassword().equals(loginForm.getPassword())) {
                    ResponseLogin responseLogin = new ResponseLogin();
                    String baseStr = admin.getEmail() + ":" + admin.getPassword();
                    String token = Base64.getEncoder().encodeToString(baseStr.getBytes());

                    responseLogin.setRole("ADMIN");
                    responseLogin.setData(admin);
                    responseLogin.setToken(token);

                    response.setPayload(responseLogin);
                    response.setStatus(true);
                    response.getMessages().add("Login success");
                    return ResponseEntity.ok(response);
                } else {
                    response.setStatus(false);
                    response.getMessages().add("Sorry, Wrong Password");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                }

            } else {
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
    public ResponseEntity<ResponseData> findAllAdmin() {
        ResponseData response = new ResponseData();
        try {
            response.setStatus(true);
            response.getMessages().add("Admin loaded");
            response.setPayload(adminService.findAll());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Could not load admin: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/showAllAdmin")
    public Iterable<Product> showAllAdmin() {
        return customerService.findAll();
    }

    @PostMapping("/addadmin")
    public ResponseEntity<ResponseData> registraton(@Valid @RequestBody AdminForm adminForm) {
        ResponseData response = new ResponseData();
        try {
            Admin customer = adminService.findByEmail(adminForm.getEmail());

            if (customer == null) {
                Admin newAdmin = new Admin();

                newAdmin.setName(adminForm.getName());
                newAdmin.setEmail(adminForm.getEmail());
                newAdmin.setPassword(MD5Generator.generate(adminForm.getPassword()));

                response.setPayload(adminService.save(newAdmin));
                response.setStatus(true);
                response.getMessages().add("Registration Success");
                return ResponseEntity.ok(response);
            } else {
                response.setStatus(false);
                response.getMessages().add("Sorry, Email already exist");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Errors: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

}
