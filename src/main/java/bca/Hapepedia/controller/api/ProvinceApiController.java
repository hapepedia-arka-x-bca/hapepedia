package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.services.ProvinceService;

@RestController
@RequestMapping("/api/province")
public class ProvinceApiController {
	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping
	public ResponseEntity<ResponseData> findAllProvinces() {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Provinces found");
			response.setPayload(provinceService.findAll());
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load provinces: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseData> findByIdProvince(@PathVariable("id") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Province found");
			response.setPayload(provinceService.findById(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load province: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
