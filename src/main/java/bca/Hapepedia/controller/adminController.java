package bca.Hapepedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bca.Hapepedia.dto.CategoryForm;
import bca.Hapepedia.services.AdminService;
import bca.Hapepedia.services.CategoryService;
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

	@GetMapping
	public String index(Model model) {
		return "admins/index";
	}

	@RequestMapping("/detailTransaction")
	public String detailTransaction(Model model) {
		return "admins/detailTransaction";
	}

	@RequestMapping("/product")
	public String product(Model model) {
		return "admins/product";
	}

	@RequestMapping("/detailProduct")
	public String detailProduct(Model model) {
		return "admins/detailProduct";
	}

	@RequestMapping("/addProduct")
	public String addProduct(Model model) {
		return "admins/detailProduct";
	}

	@RequestMapping("/listadmin")
	public String listadmin(Model model) {
		return "admins/admin";
	}

	@RequestMapping("/addAdmin")
	public String addAdmin(Model model) {
		return "admins/addAdmin";
	}

	@RequestMapping("/setting")
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

	@GetMapping("/brand")
	public String brand(Model model) {
		model.addAttribute("listOfBrand", brandService.findAll());
		return "admins/addBrand";
	}
}
