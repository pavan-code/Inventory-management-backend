package com.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IMS.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
