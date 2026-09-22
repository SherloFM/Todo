package com.ga.Todo.repository;

import com.ga.Todo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
    Category findByNameAndDescription(String name, String description);

}