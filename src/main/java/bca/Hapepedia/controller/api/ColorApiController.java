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

import bca.Hapepedia.dto.ColorForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Color;
import bca.Hapepedia.services.ColorService;

@RestController
@RequestMapping("/api/color")
public class ColorApiController {
	@Autowired
    private ColorService colorService;
	
	@GetMapping
    public ResponseEntity<ResponseData> findAllColor() {
        ResponseData response = new ResponseData();
        try {
            response.setStatus(true);
            response.getMessages().add("Colors found");
            response.setPayload(colorService.findAll());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setStatus(false);
            response.getMessages().add("Could not load colors: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseData> findByIdCategory(@PathVariable("id") Long id) {
		ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Color found");
			response.setPayload(colorService.findById(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load color: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

    @PostMapping("/save")
    public ResponseEntity<ResponseData> saveColor(@Valid @RequestBody ColorForm form, Errors errors) {
        ResponseData response = new ResponseData();
        if (!errors.hasErrors()) {
            Color color = new Color();
            color.setId(form.getId());
            color.setName(form.getName());
            
            response = new ResponseData();
            response.setStatus(true);
            response.getMessages().add("Color saved");
            response.setPayload(colorService.save(color));
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
			response.getMessages().add("Color deleted");
			response.setPayload(colorService.delete(id));
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not delete color: " + ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
