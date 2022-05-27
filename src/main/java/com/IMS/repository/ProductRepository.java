package com.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IMS.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
