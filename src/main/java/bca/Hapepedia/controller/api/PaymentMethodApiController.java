package bca.Hapepedia.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.PaymentMethodForm;
import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.PaymentMethod;
import bca.Hapepedia.services.PaymentMethodService;

@RestController
@RequestMapping("/api/paymentMethod")
public class PaymentMethodApiController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<ResponseData> findAllPaymentMethod(){
        ResponseData response = new ResponseData();
		try {
			response.setStatus(true);
			response.getMessages().add("Payment method loaded");
			response.setPayload(paymentMethodService.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load payment method: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> addPaymentMethod(@RequestBody PaymentMethodForm paymentMethodForm){
        ResponseData response = new ResponseData();
		try {
			PaymentMethod newPaymentMethod = new PaymentMethod();
			newPaymentMethod.setName(paymentMethodForm.getName());
			response.setStatus(true);
			response.getMessages().add("Payment method saved");
			response.setPayload(paymentMethodService.save(newPaymentMethod));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order status: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<ResponseData> updatePaymentMethod(@RequestBody PaymentMethodForm paymentMethodForm){
        ResponseData response = new ResponseData();
		try {
			PaymentMethod newPaymentMethod = new PaymentMethod();
			newPaymentMethod.setName(paymentMethodForm.getName());
			newPaymentMethod.setId(paymentMethodForm.getId());
			response.setStatus(true);
			response.getMessages().add("Payment method saved");
			response.setPayload(paymentMethodService.save(newPaymentMethod));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order status: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }

	@PostMapping("/delete")
    public ResponseEntity<ResponseData> deletePaymentMethod(@RequestBody PaymentMethodForm paymentMethodForm){
        ResponseData response = new ResponseData();
		try {
			PaymentMethod newPaymentMethod = new PaymentMethod();
			newPaymentMethod.setName(paymentMethodForm.getName());
			newPaymentMethod.setId(paymentMethodForm.getId());
			response.setStatus(true);
			response.getMessages().add("Payment method deleted");
			response.setPayload(paymentMethodService.delete(newPaymentMethod.getId()));
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order status: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
}
