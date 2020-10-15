package bca.Hapepedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bca.Hapepedia.dto.CategoryForm;
import bca.Hapepedia.dto.ProductForm;
import bca.Hapepedia.entity.Category;
import bca.Hapepedia.services.AdminService;
import bca.Hapepedia.services.CategoryService;
import bca.Hapepedia.services.ProductService;
import bca.Hapepedia.services.BrandService;


@Controller
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private ProductService productService;

	@GetMapping
	public String index(Model model) {
		return "admins/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "admins/login";
	}

	@GetMapping("/detailTransaction")
	public String detailTransaction(Model model) {
		return "admins/detailTransaction";
	}

	@GetMapping("/detailProduct")
	public String detailProduct(Model model) {
		return "admins/detailProduct";
	}

	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		return "admins/addProduct";
	}

	@GetMapping("/listadmin")
	public String listadmin(Model model) {
		return "admins/admin";
	}

	@GetMapping("/addAdmin")
	public String addAdmin(Model model) {
		return "admins/addAdmin";
	}

	@GetMapping("/setting")
	public String setting(Model model) {
		model.addAttribute("admin list", adminService);
		return "admins/setting";
	}

	@GetMapping("/category")
	public String category(Model model) {
		model.addAttribute("listOfCategory", categoryService.findAll());
		model.addAttribute("categoryForm", new CategoryForm());
		return "admins/addCategory";
	}
	
	@GetMapping("/color")
	public String color(Model model) {
		return "admins/addColor";
	}
	
	@GetMapping("/varian")
	public String varian(Model model) {
		return "admins/addVarian";
	}

	@GetMapping("/product")
	public String product(Model model) {
		model.addAttribute("listOfProduct", productService.findAll());
		model.addAttribute("productForm", new ProductForm());
		return "admins/product";
	}

	@PostMapping("/category/save")
	public String categorySave(CategoryForm categoryForm, Model model) {
		Category category = new Category();
		category.setName(categoryForm.getName());
		categoryService.save(category);
		return "redirect:/admins/category";
	}

	@GetMapping("/order")
	public String order(Model model) {
		model.addAttribute("listOfCategory", categoryService.findAll());
		model.addAttribute("categoryForm", new CategoryForm());
		return "admins/order";
	}

	@GetMapping("/brand")
	public String brand(Model model) {
		model.addAttribute("listOfBrand", brandService.findAll());
		return "admins/addBrand";

	}
}
