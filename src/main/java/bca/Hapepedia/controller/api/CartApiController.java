package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.services.CartService;
import bca.Hapepedia.services.CustomerService;

@RestController
@RequestMapping("/api/cart")
public class CartApiController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/getbyloggedin")
	public ResponseEntity<ResponseData> findByLoggedInCustomer(Authentication authentication) {
		ResponseData response = new ResponseData();
		Customer customer = customerService.findByEmail(authentication.getName());
		try {
			response.setStatus(true);
			response.getMessages().add("Cart found");
			response.setPayload(cartService.findAllByCustomer(customer));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load cart: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
