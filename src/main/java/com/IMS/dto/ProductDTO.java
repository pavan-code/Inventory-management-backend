package com.IMS.dto;

public class ProductDTO {
	
	private int id;
	private String name;
	private String category;
	private double price;
	private String description;
	private int threshold;
	private boolean isAvailable;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public ProductDTO(String name, String category, double price, String description, int threshold, boolean isAvailable) {
		
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.threshold = threshold;
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + ", description="
				+ description + ", threshold=" + threshold + ", isAvailable=" + isAvailable + "]";
	}	
}
