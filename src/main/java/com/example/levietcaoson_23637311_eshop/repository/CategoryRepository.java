package com.example.levietcaoson_23637311_eshop.repository;


import com.example.levietcaoson_23637311_eshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByOrderByNameAsc();
}