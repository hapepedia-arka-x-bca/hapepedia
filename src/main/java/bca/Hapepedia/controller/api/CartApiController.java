package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.services.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/cart")
public class CartApiController {
    @Autowired
    CartService cartService;

    // @GetMapping()
    // public ResponseEntity<ResponseData> findAll(@RequestParam String param) {
    //     return new SomeData();
    // }
    
}
