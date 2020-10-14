package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.services.CartService;
import bca.Hapepedia.services.CustomerService;



@RestController
@RequestMapping("/api/cart")
public class CartApiController {
    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/{idCustomer}")
    public ResponseEntity<ResponseData> findByCustomer(@PathVariable("idCustomer") Long id) {
        ResponseData response = new ResponseData();
        try{
            response.setStatus(true);
            response.getMessages().add("Cart existed");
            response.setPayload(cartService.findAllByCustomer(customerService.findById(id)));

            return ResponseEntity.ok(response);
        }

        
        catch(Exception ex)
        {
            response.setStatus(false);
            response.getMessages().add("Could not load carts: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
}
