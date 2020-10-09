package bca.Hapepedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bca.Hapepedia.dto.CategoryForm;
import bca.Hapepedia.entity.Category;
import bca.Hapepedia.services.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("listOfCategory", categoryService.findAll());
		model.addAttribute("categoryForm", new CategoryForm());
		return "admins/addCategory";
	}

	@PostMapping("/save")
	public String save(CategoryForm categoryForm, Model model) {
		Category category = new Category();
		category.setName(categoryForm.getName());
		categoryService.save(category);
		return "redirect:/admin/category";
	}
}
