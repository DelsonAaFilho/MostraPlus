package com.example.a3work.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.a3work.Model.CategoriesModel;



public interface categoriesRepository extends JpaRepository<CategoriesModel, Long>{

}
