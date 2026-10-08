package com.example.a3work.repository;

import com.example.a3work.model.CategoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface categoriesRepository extends JpaRepository<CategoriesModel, Long> {

}
