package com.ga.Todo.Controller;

import com.ga.Todo.Exceptions.InformationExistException;
import com.ga.Todo.Model.Category;
import com.ga.Todo.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/api")
public class Controller {

    private final CategoryRepository categoryRepository;

    public Controller(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/chosencategory")
    public Optional<Category> getCategories(
            @RequestParam(value = "chosen") Long chosen
    ){
        return categoryRepository.findById(chosen);
    }

    @PostMapping("/postcategories")
    public Category addCategories(@RequestBody  Category categoryObject){
        Category category = categoryRepository.findByName(categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

}
