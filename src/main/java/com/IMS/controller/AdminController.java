package com.IMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IMS.dto.CategoryDTO;
import com.IMS.dto.ProductDTO;
import com.IMS.entity.Category;
import com.IMS.entity.Product;
import com.IMS.entity.UserResponse;
import com.IMS.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/category")
	public UserResponse<Category> saveCategory(@RequestBody CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		Category cat = adminService.saveCategory(category);
		return new UserResponse<>(true, 200, "Category saved Successfully!", cat, null);
	}
	
	@GetMapping("/category") 
	public UserResponse<Category> allCategories() {
		List<Category> categories = adminService.allCategories();
		return new UserResponse<>(true, 200, "List of all categories", null, categories);
	}
	
	@PutMapping("/category")
	public UserResponse<Category> updateCategory(@RequestBody CategoryDTO categoryDTO) {
		Category category = adminService.getCategory(categoryDTO.getId());
		if(category != null) {
			category.setName(categoryDTO.getName());
			category = adminService.updateCategory(category);
			return new UserResponse<>(true, 200, "Category updated successfully!", category, null);
		} else {
			return new UserResponse<>(true, 200, "Category not found with id: " + categoryDTO.getId(), null, null);
		}
	}
	
	@PostMapping("/product")
	public UserResponse<Product> saveProduct(@RequestBody ProductDTO productDTO) {
		Product product = new Product(productDTO);
		Product pro = adminService.saveProduct(product);
		return new UserResponse<>(true, 200, "Product saved Successfully!", pro, null);
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		return adminService.getProduct(id);
	}
	
	@GetMapping("/product")
	public UserResponse<Product> allProducts() {
		List<Product> products = adminService.allProducts();
		return new UserResponse<>(true, 200, "List of all products", null, products);
	}
	
	@PutMapping("/product")
	public UserResponse<Product> updateProduct(@RequestBody ProductDTO productDTO) {
		Product product = getProduct(productDTO.getId());
		if(product != null) {
			product.setName(productDTO.getName());
			product.setCategory(productDTO.getCategory());
			product.setDescription(productDTO.getDescription());
			product.setPrice(productDTO.getPrice());
			product.setThreshold(productDTO.getThreshold());
			product.setAvailable(productDTO.isAvailable());
			
			product = adminService.updateProduct(product);
			return new UserResponse<>(true, 200, "Product updated successfully!", product, null);
		} else {
			return new UserResponse<>(false, 404, "Product not found with id: " + productDTO.getId(), null, null);
		}		
	}
	
	@DeleteMapping("/product/{id}")
	public UserResponse<Product> deleteProduct(@PathVariable int id) {
		Product product = getProduct(id);
		if(product != null) {
			adminService.deleteProduct(id);
			return new UserResponse<>(true, 200, "Product with id: " + id + " is deleted.", null, null);
		} else {
			return new UserResponse<>(false, 404, "Product not found with id: " + id, null, null);
		}
	}
}
