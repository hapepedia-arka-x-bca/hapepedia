package bca.Hapepedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import bca.Hapepedia.services.ProductImageService;


@Controller
@RequestMapping("/")
public class indexController {

	@Autowired
	private ProductImageService productImageService;


	@GetMapping
	public String index(Model model) {
		return "customers/index";
	}

	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("listOfProduct", productImageService.findByMainTrue());
		return "customers/shop";
	}

	@GetMapping("/product-details")
	public String productDetail(Model model) {
		return "customers/product-details";
	}
	
	@GetMapping("/cart")
	public String cart(Model model) {
		return "customers/cart";
	}
	
	@GetMapping("/wishlist")
	public String wishlist(Model model) {
		return "customers/wishlist";
	}	

	@GetMapping("/checkout")
	public String checkout(Model model) {
		return "customers/checkout";
	}	

	@GetMapping("/order")
	public String order(Model model) {
		return "customers/order";
	}	

	@GetMapping("/transaction")
	public String transaction(Model model) {
		return "customers/transaction";
	}	
	
	@GetMapping("/setting")
	public String setting(Model model) {
		return "customers/setting";
	}	

	@GetMapping("/login")
	public String login(Model model) {
		return "customers/login";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword(Model model) {
		return "admins/password";
	}	

	@GetMapping("/registration")
	public String logregisin(Model model) {
		return "admins/register";
	}	
	
	@GetMapping("/profile")
	public String category(Model model, Authentication authentication) {
//		model.addAttribute("customerForm", customerService.);
		System.out.println(authentication);
		return "customers/profile";
	}
}
