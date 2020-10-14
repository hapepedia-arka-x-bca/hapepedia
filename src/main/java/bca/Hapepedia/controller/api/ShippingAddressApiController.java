package bca.Hapepedia.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bca.Hapepedia.dto.CategoryForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.dto.ShippingAddressForm;
import bca.Hapepedia.entity.Category;
import bca.Hapepedia.entity.City;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.Province;
import bca.Hapepedia.entity.ShippingAddress;
import bca.Hapepedia.services.ShippingAddressService;
import bca.Hapepedia.services.CityService;
import bca.Hapepedia.services.CustomerService;
import bca.Hapepedia.services.ProvinceService;

@RestController
@RequestMapping("/api/address")
public class ShippingAddressApiController {
	@Autowired
	private ShippingAddressService shippingAddressService;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping("/getbyloggedin")
	public ResponseEntity<ResponseData> findByLoggedInCustomer(Authentication authentication) {
		ResponseData response = new ResponseData();
		Customer customer = customerService.findByEmail(authentication.getName());
		try {
			response.setStatus(true);
			response.getMessages().add("Addresses found");
			response.setPayload(shippingAddressService.findAllByCustomer(customer));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load addresses: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<ResponseData> saveCategory(@Valid @RequestBody ShippingAddressForm form, Errors errors,
			Authentication authentication) {
		ResponseData response = new ResponseData();
		if (!errors.hasErrors()) {
			Customer customer = customerService.findByEmail(authentication.getName());
			City city = cityService.findById(form.getCityId()).get();
			Province province = provinceService.findById(form.getProvinceId()).get();
			
			ShippingAddress address = new ShippingAddress();
			address.setId(form.getId());
			address.setCustomer(customer);
			address.setReceiverName(form.getReceiverName());
			address.setAddressDetail(form.getAddressDetail());
			address.setCity(city);
			address.setProvince(province);
			address.setPostalCode(form.getPostalCode());

			response.setStatus(true);
			response.getMessages().add("Province saved");
			response.setPayload(shippingAddressService.save(address));
			System.out.println(authentication.getName());
			return ResponseEntity.ok(response);
		} else {
			response.setStatus(false);
			for (ObjectError err : errors.getAllErrors()) {
				response.getMessages().add(err.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<ResponseData> deleteCategory(@PathVariable("id") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Address deleted");
			response.setPayload(shippingAddressService.delete(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not delete address: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
