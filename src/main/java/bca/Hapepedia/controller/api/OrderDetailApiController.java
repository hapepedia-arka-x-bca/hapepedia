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

import bca.Hapepedia.dto.OrderDetailForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.OrderDetail;
import bca.Hapepedia.services.OrderDetailService;
import bca.Hapepedia.services.OrderService;
import bca.Hapepedia.services.ProductDetailService;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
	private OrderService orderService;
    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping("/add")
    public ResponseEntity<ResponseData> addOrder(@RequestBody OrderDetailForm orderDetailForm){
        ResponseData response = new ResponseData();
		try {
            OrderDetail newOrderDetail = new OrderDetail();
            
            newOrderDetail.setOrder(orderService.findById(orderDetailForm.getOrderId()).get());
            newOrderDetail.setProductDetail(productDetailService.findById(orderDetailForm.getProductDetailId()).get());
            newOrderDetail.setQuantity(orderDetailForm.getQuantity());
            
			response.setStatus(true);
			response.getMessages().add("Order saved");
			response.setPayload(orderDetailService.save(newOrderDetail));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<ResponseData> updateOrder(@RequestBody OrderDetailForm orderDetailForm){
        ResponseData response = new ResponseData();
		try {
            OrderDetail newOrderDetail = new OrderDetail();
            
			newOrderDetail.setOrder(orderService.findById(orderDetailForm.getOrderId()).get());
            newOrderDetail.setProductDetail(productDetailService.findById(orderDetailForm.getProductDetailId()).get());
            newOrderDetail.setQuantity(orderDetailForm.getQuantity());
            
                        
			response.setStatus(true);
			response.getMessages().add("Order updated");
			response.setPayload(orderDetailService.save(newOrderDetail));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData> deleteOrder(@PathVariable("id") Long idOrder){
        ResponseData response = new ResponseData();
		try {
            
			response.setStatus(true);
			response.getMessages().add("Order deleted");
			response.setPayload(orderDetailService.delete(idOrder));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

	@GetMapping("/show/{id}")
    public ResponseEntity<ResponseData> findAllOrder(@PathVariable("id") Long idOrder){
        ResponseData response = new ResponseData();
		try {
			
			response.setStatus(true);
			response.getMessages().add("Order detail loaded");
			response.setPayload(orderDetailService.findAllByOrder(orderService.findById(idOrder).get()));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order detail: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
}
