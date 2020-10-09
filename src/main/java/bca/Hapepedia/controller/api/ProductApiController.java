package bca.Hapepedia.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ProductForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Product;
import bca.Hapepedia.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ResponseData> findAll()
    {
        ResponseData response = new ResponseData();
        try
        {
            response.setStatus(true);
            response.getMessages().add("Products found");
            response.setPayload(productService.findAll());

            return ResponseEntity.ok(response);
        }

        catch(Exception ex)
        {
            response.setStatus(false);
            response.getMessages().add("Could not load products: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseData> saveProduct(@Valid ProductForm productForm, BindingResult bindingResult)
    {
        ResponseData response = new ResponseData();
        if(!bindingResult.hasErrors())
        {
            Product product = new Product();
            product.setId(productForm.getId());
            product.setBrand(1L);
            product.setCategory(1L);
            product.setName(productForm.getName());
            product.setSpecification(productForm.getSpecification());
            product.setWeight(productForm.getWeight());
            

            response = new ResponseData();
			response.setStatus(true);
            response.getMessages().add("Product saved");
            response.setPayload(productService.save(product));
        }

        else
        {
            for(ObjectError err:bindingResult.getAllErrors())
            {
                response.setStatus(false);
                response.getMessages().add(err.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
