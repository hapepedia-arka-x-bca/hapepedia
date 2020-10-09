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

import bca.Hapepedia.dto.CategoryForm;
import bca.Hapepedia.dto.DeleteForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Category;
import bca.Hapepedia.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<ResponseData> findAllCategory() {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Categories found");
			response.setPayload(categoryService.findAll());
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load categories: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@GetMapping("/get")
	public ResponseEntity<ResponseData> findByIdCategory(@RequestParam("id") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Category found");
			response.setPayload(categoryService.findById(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load category: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping
	public ResponseEntity<ResponseData> saveCategory(@Valid @RequestBody CategoryForm form, Errors errors) {
		ResponseData response = new ResponseData();
		if (!errors.hasErrors()) {
			Category category = new Category();
			category.setId(form.getId());
			category.setName(form.getName());
			response = new ResponseData();
			response.setStatus(true);
			response.getMessages().add("Category saved");
			response.setPayload(categoryService.save(category));
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
			response.setPayload(categoryService.delete(form.getId()));
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
