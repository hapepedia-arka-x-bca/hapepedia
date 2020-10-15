package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.WishlistForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Wishlist;
import bca.Hapepedia.services.WishlistService;
import bca.Hapepedia.services.CustomerService;
import bca.Hapepedia.services.ProductDetailService;



@RestController
@RequestMapping("/api/wishlist")
public class WishlistApiController {
    @Autowired
    WishlistService wishlistService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductDetailService productDetailService;

    @GetMapping("/show/{idCustomer}")
    public ResponseEntity<ResponseData> findByCustomer(@PathVariable("idCustomer") Long id) {
        ResponseData response = new ResponseData();
        try{
            response.setStatus(true);
            response.getMessages().add("Wishlist existed");
            response.setPayload(wishlistService.findAllByCustomer(customerService.findById(id)));

            return ResponseEntity.ok(response);
        }

        
        catch(Exception ex)
        {
            response.setStatus(false);
            response.getMessages().add("Could not load wishlists: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> addWishlist(@RequestBody WishlistForm wishlistForm){
        ResponseData response = new ResponseData();
		try {
			Wishlist tempWishlist = new Wishlist();
			tempWishlist = wishlistService.findByProductDetailandByCustomer(productDetailService.findById(wishlistForm.getProductDetailId()).get(), customerService.findById(wishlistForm.getCustomerId()).get()).get();

			if(tempWishlist!=null){
				Wishlist newWishlist = new Wishlist();
				newWishlist.setCustomer(customerService.findById(wishlistForm.getCustomerId()).get());
				newWishlist.setProductDetail(productDetailService.findById(wishlistForm.getProductDetailId()).get());
				response.setStatus(true);
				response.getMessages().add("Wishlist saved");
				response.setPayload(wishlistService.save(newWishlist));
				return ResponseEntity.ok(response);
			}
			else{
				response.setStatus(false);
				response.getMessages().add("Product already in wishlist");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load wishlist: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<ResponseData> updateWishlist(@RequestBody WishlistForm wishlistForm){
        ResponseData response = new ResponseData();
		try {
			Wishlist newWishlist = new Wishlist();
			newWishlist.setCustomer(customerService.findById(wishlistForm.getCustomerId()).get());
			newWishlist.setProductDetail(productDetailService.findById(wishlistForm.getProductDetailId()).get());
			newWishlist.setId(wishlistForm.getId());
			response.setStatus(true);
			response.getMessages().add("Wishlist saved");
			response.setPayload(wishlistService.save(newWishlist));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load wishlist: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

	@DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData> deleteWishlist(@PathVariable("id") Long id){
        ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Wishlist deleted");
			response.setPayload(wishlistService.delete(id));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load wishlist: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
}
