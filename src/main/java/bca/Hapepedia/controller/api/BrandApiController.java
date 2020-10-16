package bca.Hapepedia.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.BrandForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Brand;
import bca.Hapepedia.services.BrandService;

@RestController
@RequestMapping("/api/brand")
public class BrandApiController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<ResponseData> findAllBrand() {
        ResponseData response = new ResponseData();
        try {
            response.setStatus(true);
            response.getMessages().add("Categories found");
            response.setPayload(brandService.findAll());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Could not load brands: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseData> findByIdBrand(@PathVariable("id") Long id) {
        ResponseData response = new ResponseData();
        try {
            response.setStatus(true);
            response.getMessages().add("Brand found");
            response.setPayload(brandService.findById(id));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Could not load brand: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseData> saveBrand(@Valid @RequestBody BrandForm form, Errors errors) {
        ResponseData response = new ResponseData();
        if (!errors.hasErrors()) {
            Brand brand = new Brand();
            brand.setId(form.getId());
            brand.setName(form.getName());

            response.setStatus(true);
            response.getMessages().add("Brand saved");
            response.setPayload(brandService.save(brand));
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
    public ResponseEntity<ResponseData> deleteBrand(@PathVariable("id") Long id) {
        ResponseData response = new ResponseData();
        try {
            response.setStatus(true);
            response.getMessages().add("Brand deleted");
            response.setPayload(brandService.delete(id));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Could not delete brand: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
