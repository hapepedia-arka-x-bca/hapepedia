package bca.Hapepedia.controller.api;

import com.midtrans.httpclient.error.MidtransError;
import com.midtrans.service.MidtransSnapApi;

import java.util.HashMap;
import java.util.Map;

import com.midtrans.Config;
import com.midtrans.ConfigFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bca.Hapepedia.dto.ResponseData;
import bca.Hapepedia.entity.Order;
import bca.Hapepedia.services.OrderService;

@RestController
@RequestMapping("/api/midtrans")
public class MidtransApiController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/generate/{id}")
	public  ResponseEntity<ResponseData> testAPI(@PathVariable("id") Long id) throws MidtransError{
        ResponseData response = new ResponseData();
		try {           
            // Create new Object SnapAPI
            MidtransSnapApi snapApi = new ConfigFactory(new Config("SB-Mid-server-_KkTkDYAemQNP34yFORNLbnZ","SB-Mid-client-D3hHGhIai1Y8dxDf", false)).getSnapApi();
            // Set 3rd param to true if you want Production Environment (accept real transaction).
            // Create params JSON Raw Object request
                        
            // Create Token and then you can send token variable to FrontEnd,
            // to initialize Snap JS when customer click pay button
            // String transactionToken = snapApi.createTransactionToken(requestBody(id));
            String transactionUrl = snapApi.createTransactionRedirectUrl(requestBody(id));
		

			response.setStatus(true);
			response.getMessages().add("Order Success");
			response.setPayload(transactionUrl);
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			response.setStatus(false);
			response.getMessages().add("Could not load order: "+ ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
    public Map<String, Object> requestBody(Long id) {
        Order newOrder = new Order();
        newOrder = orderService.findById(id).get();
        Map<String, Object> params = new HashMap<>();
        System.out.println("THIS >>>"+id);
        String stringId = Long.toString(id);
        Map<String, String> transactionDetails = new HashMap<>();
        transactionDetails.put("order_id", "O"+stringId);
        transactionDetails.put("gross_amount", newOrder.getTotalPayment().toString());

        Map<String, String> creditCard = new HashMap<>();
        creditCard.put("secure", "true");

        params.put("transaction_details", transactionDetails);
        params.put("credit_card", creditCard);

        return params;
    }
}
