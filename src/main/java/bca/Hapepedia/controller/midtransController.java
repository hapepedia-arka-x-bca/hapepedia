package bca.Hapepedia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class midtransController {
   	
	@GetMapping
	public String index() {
		return "midtrans/index";
	}

	@GetMapping("/error")
	public String shop(Model model) {
		return "midtrans/error";
	}

	@GetMapping("/success")
	public String productDetail(Model model) {
		return "midtrans/success";
	}
	
	
}
