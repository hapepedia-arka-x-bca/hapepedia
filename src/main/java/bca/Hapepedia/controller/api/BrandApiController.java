package bca.Hapepedia.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.BrandForm;
import bca.Hapepedia.dto.DeleteForm;
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
            response.getMessages().add("Brands found");
            response.setPayload(brandService.findAll());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Could not load brands: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseData> findByIdBrand(@RequestParam("id") Long id) {
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

    @PostMapping
    public ResponseEntity<ResponseData> saveBrand(@Valid @RequestBody BrandForm form, Errors errors) {
        ResponseData response = new ResponseData();
        if (!errors.hasErrors()) {
            Brand brand = new Brand();
            brand.setId(form.getId());
            brand.setName(form.getName());
            response = new ResponseData();
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

    @DeleteMapping
    public ResponseEntity<ResponseData> deleteCategory(@Valid @RequestBody DeleteForm form, Errors errors) {
        ResponseData response = new ResponseData();
        if (!errors.hasErrors()) {
            response = new ResponseData();
            response.setStatus(true);
            response.getMessages().add("Category deleted");
            response.setPayload(brandService.delete(form.getId()));
            return ResponseEntity.ok(response);
        } else {
            response.setStatus(false);
            for (ObjectError err : errors.getAllErrors()) {
                response.getMessages().add(err.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}