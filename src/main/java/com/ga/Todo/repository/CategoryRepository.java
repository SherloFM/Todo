package com.ga.Todo.repository;

import com.ga.Todo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
    Category findByNameAndDescription(String name, String description);
    Category findByUserIdAndName(Long userId, String name);
    List<Category> findByUserId(Long Id);
    Category findByUserIdAndId(Long userId, Long categoryId);
}