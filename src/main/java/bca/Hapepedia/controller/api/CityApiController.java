package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Province;
import bca.Hapepedia.services.CityService;
import bca.Hapepedia.services.ProvinceService;

@RestController
@RequestMapping("/api/city")
public class CityApiController {
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ProvinceService provinceService;

	@GetMapping
	public ResponseEntity<ResponseData> findAllCities() {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Cities found");
			response.setPayload(cityService.findAll());
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load cities: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@GetMapping("/getbyprovince/{id}")
	public ResponseEntity<ResponseData> findByIdProvince(@PathVariable("id") Long id) {
		ResponseData response = new ResponseData();
		Province province = provinceService.findById(id).get();
		try {
			response.setStatus(true);
			response.getMessages().add("Cities found");
			response.setPayload(cityService.findAllByProvince(province));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load cities: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}