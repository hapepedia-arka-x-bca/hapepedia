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

import bca.Hapepedia.dto.ProductDetailForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.ProductDetail;
import bca.Hapepedia.services.ColorService;
import bca.Hapepedia.services.ProductDetailService;
import bca.Hapepedia.services.ProductService;
import bca.Hapepedia.services.VarianService;

@RestController
@RequestMapping("/api/productDetail")
public class ProductDetailApiController {
    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ColorService colorService;
    
    @Autowired
    private VarianService varianService;
    

    

    @GetMapping("/show/{id}")
    public ResponseEntity<ResponseData> findAll(@PathVariable("id") Long id)
    {
        ResponseData response = new ResponseData();
        try
        {
            response.setStatus(true);
            response.getMessages().add("Product Details found");
            response.setPayload(productDetailService.findById(id));

            return ResponseEntity.ok(response);
        }

        catch(Exception ex)
        {
            response.setStatus(false);
            response.getMessages().add("Could not load product Details: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ResponseData> findByProduct(@PathVariable("id") Long id)
    {
        ResponseData response = new ResponseData();
        try
        {
            response.setStatus(true);
            response.getMessages().add("Product Details found");
            response.setPayload(productDetailService.findByProduct(productService.findById(id).get()));

            return ResponseEntity.ok(response);
        }

        catch(Exception ex)
        {
            response.setStatus(false);
            response.getMessages().add("Could not load product Details: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseData> save(@Valid @RequestBody ProductDetailForm productDetailForm, Errors errors)
    {
        ResponseData response = new ResponseData();
        if(!errors.hasErrors())
        {
            ProductDetail productDetail = new ProductDetail();
            productDetail.setId(productDetailForm.getId());
            productDetail.setProduct(productService.findById(productDetailForm.getProduct()).get());
            productDetail.setColor(colorService.findById(productDetailForm.getColor()).get());
            productDetail.setVarian(varianService.findById(productDetailForm.getVarian()).get());
            productDetail.setStock(productDetailForm.getStock());
            productDetail.setPrice(productDetailForm.getPrice());

            response = new ResponseData();
			response.setStatus(true);
            response.getMessages().add("Product Detail saved");
            response.setPayload(productDetailService.save(productDetail));

            return ResponseEntity.ok(response);
        }

        else
        {
        	response.setStatus(false);
            for(ObjectError err:errors.getAllErrors())
            {
                response.getMessages().add(err.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData> deleteProductDetail(@PathVariable("id") Long id)
    {
        ResponseData response = new ResponseData();
		try {
            
			response.setStatus(true);
			response.getMessages().add("Order deleted");
			response.setPayload(productDetailService.delete(id));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
}
