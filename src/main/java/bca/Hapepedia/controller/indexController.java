package bca.Hapepedia.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {
   	
	@GetMapping
	public String index(Model model) {
		return "customers/index";
	}

	@RequestMapping("/shop")
	public String shop(Model model) {
		return "customers/shop";
	}

	@RequestMapping("/product-details")
	public String productDetail(Model model) {
		return "customers/product-details";
	}
	
	@RequestMapping("/cart")
	public String cart(Model model) {
		return "customers/cart";
	}
	
	@RequestMapping("/wishlist")
	public String wishlist(Model model) {
		return "customers/wishlist";
	}	

	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return "customers/checkout";
	}	

	@RequestMapping("/order")
	public String order(Model model) {
		return "customers/order";
	}	

	@RequestMapping("/transaction")
	public String transaction(Model model) {
		return "customers/transaction";
	}	
	
	@RequestMapping("/setting")
	public String setting(Model model) {
		return "customers/setting";
	}	

	@RequestMapping("/login")
	public String login(Model model) {
		return "admins/login";
	}

	@RequestMapping("/forgotPassword")
	public String forgotPassword(Model model) {
		return "admins/password";
	}	

	@RequestMapping("/registration")
	public String logregisin(Model model) {
		return "admins/register";
	}	
	
}
