package com.IMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IMS.entity.Category;
import com.IMS.entity.Product;
import com.IMS.entity.User;
import com.IMS.repository.CategoryRepository;
import com.IMS.repository.ProductRepository;
import com.IMS.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category getCategory(int id) {
		Optional<Category> category = categoryRepo.findById(id);
		if(category.isPresent())
			return category.get();
		else
			return null;
	}
	
	public Category deleteCategory(int id) {
		Category cat = getCategory(id);
		if(cat != null) {
			categoryRepo.deleteById(id);
			return cat;
		} else return null;
	}
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product getProduct(int id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent())
			return product.get();
		else
			return null;
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	public Product deleteProduct(int id) {
		Product pro = getProduct(id);
		if(pro != null) {
			productRepo.deleteById(id);
			return pro;
		} else 
			return null;
	}
}
