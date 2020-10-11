package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.OrderStatusForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.OrderStatus;
import bca.Hapepedia.services.OrderStatusService;

@RestController
@RequestMapping("/api/orderStatus")
public class OrderStatusApiController {
    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping
    public ResponseEntity<ResponseData> findAllOrderStatus(){
        ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Order status loaded");
			response.setPayload(orderStatusService.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order status: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> addOrderStatus(@RequestBody OrderStatusForm orderStatusForm){
        ResponseData response = new ResponseData();
		try {
			OrderStatus newOrderStatus = new OrderStatus();
			newOrderStatus.setOrderstatus(orderStatusForm.getOrderstatus());
			response.setStatus(true);
			response.getMessages().add("Order status saved");
			response.setPayload(orderStatusService.save(newOrderStatus));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order status: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<ResponseData> updateOrderStatus(@RequestBody OrderStatusForm orderStatusForm){
        ResponseData response = new ResponseData();
		try {
			OrderStatus newOrderStatus = new OrderStatus();
			newOrderStatus.setOrderstatus(orderStatusForm.getOrderstatus());
			newOrderStatus.setId(orderStatusForm.getId());
			response.setStatus(true);
			response.getMessages().add("Order status saved");
			response.setPayload(orderStatusService.save(newOrderStatus));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order status: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

	@PostMapping("/delete")
    public ResponseEntity<ResponseData> deleteOrderStatus(@RequestBody OrderStatusForm orderStatusForm){
        ResponseData response = new ResponseData();
		try {
			OrderStatus newOrderStatus = new OrderStatus();
			newOrderStatus.setOrderstatus(orderStatusForm.getOrderstatus());
			newOrderStatus.setId(orderStatusForm.getId());
			response.setStatus(true);
			response.getMessages().add("Order status deleted");
			response.setPayload(orderStatusService.delete(newOrderStatus.getId()));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order status: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
}
