package bca.Hapepedia.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.DeleteForm;
import bca.Hapepedia.dto.ProductForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Product;
import bca.Hapepedia.services.BrandService;
import bca.Hapepedia.services.CategoryService;
import bca.Hapepedia.services.ProductImageService;
import bca.Hapepedia.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductImageService productImageService;

    @GetMapping
    public ResponseEntity<ResponseData> findAll()
    {
        ResponseData response = new ResponseData();
        try
        {
            response.setStatus(true);
            response.getMessages().add("Products found");

            response.setPayload(productImageService.findByMainTrue());

            return ResponseEntity.ok(response);
        }

        catch(Exception ex)
        {
            response.setStatus(false);
            response.getMessages().add("Could not load products: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("show/{id}")
    public ResponseEntity<ResponseData> findById(@PathVariable("id") Long id)
    {
        ResponseData response = new ResponseData();
        try
        {
            response.setStatus(true);
            response.getMessages().add("Products found");
            response.setPayload(productService.findById(id));
            return ResponseEntity.ok(response);
        }

        catch(Exception ex)
        {
            response.setStatus(false);
            response.getMessages().add("Could not load products: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("category/{id}")
    public ResponseEntity<ResponseData> findByCategory(@PathVariable("id") Long id)
    {
        ResponseData response = new ResponseData();
        try
        {
            response.setStatus(true);
            response.getMessages().add("Products found");
            response.setPayload(productService.findAllByCategory(categoryService.findById(id).get()));
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
    public ResponseEntity<ResponseData> save(@Valid @RequestBody ProductForm productForm, Errors errors)
    {
        ResponseData response = new ResponseData();
        if(!errors.hasErrors())
        {
            Product product = new Product();
            product.setId(productForm.getId());
            product.setBrand(brandService.findById(productForm.getBrand_id()).get());
            product.setCategory(categoryService.findById(productForm.getId_category()).get());//long
            product.setName(productForm.getName());
            product.setSpecification(productForm.getSpecification());
            product.setWeight(productForm.getWeight());
            

            response = new ResponseData();
			response.setStatus(true);
            response.getMessages().add("Product saved");
            response.setPayload(productService.save(product));

            return ResponseEntity.ok(response);
        }

        else
        {
            for(ObjectError err:errors.getAllErrors())
            {
                response.setStatus(false);
                response.getMessages().add(err.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping
    public ResponseEntity<ResponseData> deleteProduct(@Valid @RequestBody DeleteForm form, Errors errors)
    {
        ResponseData response = new ResponseData();
        if(!errors.hasErrors())
        {
            response = new ResponseData();
			response.setStatus(true);
            response.getMessages().add("Product deleted");
            
            response.setPayload(productService.delete(form.getId()));

            return ResponseEntity.ok(response);
        }

        else
        {
            response.setStatus(false);
			for (ObjectError err : errors.getAllErrors()) {
				response.getMessages().add(err.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
