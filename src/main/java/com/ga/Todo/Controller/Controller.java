package com.ga.Todo.Controller;

import com.ga.Todo.Exceptions.InformationExistException;
import com.ga.Todo.Model.Category;
import com.ga.Todo.Service.CategoryService;
import com.ga.Todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.ListenerNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class Controller {

    public CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/hello")
    public String hello(){
        return categoryService.hello();
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/chosencategory")
    public Optional<Category> getCategories(Long id){
        return categoryService.getCategories(id);
    }

    @PostMapping("/postcategories")
    public Category addCategories(Category categoryObject){
       return categoryService.addCategories(categoryObject);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(Long id){
        categoryService.deleteCategory(id);
    }

    @PutMapping(value = "upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Category uploadImage(MultipartFile img,Long id) throws IOException {
        return categoryService.uploadImage(img,id);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(
            @PathVariable Long id,
            @RequestBody Category categoryObject
    ){
        return categoryService.updateCategory(categoryObject,id);
    }

}
