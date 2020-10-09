package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ResponseData;
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
}
