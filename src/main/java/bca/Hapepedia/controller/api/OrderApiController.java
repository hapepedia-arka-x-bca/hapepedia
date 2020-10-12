package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.OrderForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Order;
import bca.Hapepedia.services.CustomerService;
import bca.Hapepedia.services.OrderService;
import bca.Hapepedia.services.OrderStatusService;

@RestController
@RequestMapping("/api/order")
public class OrderApiController {
    @Autowired
    private OrderService orderService;
    @Autowired
	private OrderStatusService orderStatusService;
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<ResponseData> findAllOrder(){
        ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Order loaded");
			response.setPayload(orderService.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> addOrder(@RequestBody OrderForm orderForm){
        ResponseData response = new ResponseData();
		try {
            Order newOrder = new Order();
            
            newOrder.setDateOrder(orderForm.getDateOrder());
            newOrder.setDeliveryAddress(orderForm.getDeliveryAddress());
            newOrder.setTotalPrice(orderForm.getTotalPrice());
            newOrder.setTotalWeight(orderForm.getTotalWeight());
            newOrder.setShippingFee(orderForm.getShippingFee());
            newOrder.setTotalPayment(orderForm.getTotalPayment());
            newOrder.setOrderStatus(orderStatusService.findById(orderForm.getOrderStatus()).get());
            newOrder.setCustomer(customerService.findById(orderForm.getCustomer()).get());
            
			response.setStatus(true);
			response.getMessages().add("Order saved");
			response.setPayload(orderService.save(newOrder));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<ResponseData> updateOrder(@RequestBody OrderForm orderForm){
        ResponseData response = new ResponseData();
		try {
            Order newOrder = new Order();
            
            newOrder.setDateOrder(orderForm.getDateOrder());
            newOrder.setDeliveryAddress(orderForm.getDeliveryAddress());
            newOrder.setTotalPrice(orderForm.getTotalPrice());
            newOrder.setTotalWeight(orderForm.getTotalWeight());
            newOrder.setShippingFee(orderForm.getShippingFee());
            newOrder.setTotalPayment(orderForm.getTotalPayment());
            newOrder.setOrderStatus(orderStatusService.findById(orderForm.getOrderStatus()).get());
            newOrder.setCustomer(customerService.findById(orderForm.getCustomer()).get());
                        
			response.setStatus(true);
			response.getMessages().add("Order updated");
			response.setPayload(orderService.save(newOrder));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseData> deleteOrder(@RequestBody OrderForm orderForm){
        ResponseData response = new ResponseData();
		try {
            
			response.setStatus(true);
			response.getMessages().add("Order deleted");
			response.setPayload(orderService.delete(orderForm.getId()));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

}
