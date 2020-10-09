package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.entity.Product;
import bca.Hapepedia.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> findAll()
    {
        return productService.findAll();
    }
}
