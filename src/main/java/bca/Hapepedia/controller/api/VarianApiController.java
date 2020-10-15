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

import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.dto.VarianForm;
import bca.Hapepedia.entity.Category;
import bca.Hapepedia.entity.Varian;
import bca.Hapepedia.services.CategoryService;
import bca.Hapepedia.services.VarianService;

@RestController
@RequestMapping("/api/varian")
public class VarianApiController {
	@Autowired
    private VarianService varianService;

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
    public ResponseEntity<ResponseData> findAllVarian() {
        ResponseData response = new ResponseData();
        try {
            response.setStatus(true);
            response.getMessages().add("Variants found");
            response.setPayload(varianService.findAll());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Could not load variants: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseData> findByIdVarian(@PathVariable("id") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Variant found");
			response.setPayload(varianService.findById(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load variant: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

    @PostMapping("/save")
    public ResponseEntity<ResponseData> saveVarian(@Valid @RequestBody VarianForm form, Errors errors) {
        ResponseData response = new ResponseData();
        if (!errors.hasErrors()) {
        	
        	Category category = categoryService.findById(form.getCategoryId()).get();
        	
            Varian varian = new Varian();
            varian.setId(form.getId());
            varian.setName(form.getName());
            varian.setCategory(category);
            
            response = new ResponseData();
            response.setStatus(true);
            response.getMessages().add("Variant saved");
            response.setPayload(varianService.save(varian));
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
	public ResponseEntity<ResponseData> deleteVarian(@PathVariable("id") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Varian deleted");
			response.setPayload(varianService.delete(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not delete varian: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
