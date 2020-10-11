package bca.Hapepedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bca.Hapepedia.dto.CategoryForm;
import bca.Hapepedia.entity.Category;
import bca.Hapepedia.services.AdminService;
import bca.Hapepedia.services.CategoryService;

@Controller
@RequestMapping("/admin")
public class adminController {
	   
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CategoryService categoryService;


	@GetMapping
	public String index(Model model) {
		return "admins/index";
	}

	@GetMapping("/detailTransaction")
	public String detailTransaction(Model model) {
		return "admins/detailTransaction";
	}

	@GetMapping("/product")
	public String product(Model model) {
		return "admins/product";
	}

	@GetMapping("/detailProduct")
	public String detailProduct(Model model) {
		return "admins/detailProduct";
	}

	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		return "admins/detailProduct";
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
}
