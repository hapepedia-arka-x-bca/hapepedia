package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.CartForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Cart;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.services.CartService;
import bca.Hapepedia.services.CustomerService;
import bca.Hapepedia.services.ProductDetailService;

@RestController
@RequestMapping("/api/cart")
public class CartApiController {
	@Autowired
	CartService cartService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductDetailService productDetailService;

	@GetMapping("/{idCustomer}")
	public ResponseEntity<ResponseData> findByCustomer(@PathVariable("idCustomer") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Cart existed");
			response.setPayload(cartService.findAllByCustomer(customerService.findById(id)));

			return ResponseEntity.ok(response);
		}

		catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load carts: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseData> addCart(@RequestBody CartForm cartForm) {
		ResponseData response = new ResponseData();
		try {
			Cart newCart = new Cart();
			newCart.setCustomer(customerService.findById(cartForm.getCustomerId()).get());
			newCart.setProductDetail(productDetailService.findById(cartForm.getProductDetailId()).get());
			newCart.setQuantity(cartForm.getQuantity());
			response.setStatus(true);
			response.getMessages().add("Cart saved");
			response.setPayload(cartService.save(newCart));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load cart: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<ResponseData> updateCart(@RequestBody CartForm cartForm) {
		ResponseData response = new ResponseData();
		try {
			Cart newCart = new Cart();
			newCart.setCustomer(customerService.findById(cartForm.getCustomerId()).get());
			newCart.setProductDetail(productDetailService.findById(cartForm.getProductDetailId()).get());
			newCart.setQuantity(cartForm.getQuantity());
			newCart.setId(cartForm.getId());
			response.setStatus(true);
			response.getMessages().add("Cart saved");
			response.setPayload(cartService.save(newCart));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load cart: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseData> deleteCart(@PathVariable("id") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Cart deleted");
			response.setPayload(cartService.delete(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load cart: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

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
