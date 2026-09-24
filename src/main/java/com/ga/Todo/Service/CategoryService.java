package com.ga.Todo.Service;

import com.ga.Todo.Exceptions.InformationExistException;
import com.ga.Todo.Model.Category;
import com.ga.Todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }


    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public String hello(){
        return "Hello World!";
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }


    public Optional<Category> getCategories(
            @RequestParam(value = "chosen") Long chosen
    ){
        return categoryRepository.findById(chosen);
    }


    public Category addCategories(@RequestBody Category categoryObject){
        Category category = categoryRepository.findByName(categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }


    public void deleteCategory(
            @PathVariable Long id
    ){
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isEmpty()){
            throw new InformationExistException("no file");
        }else{
            categoryRepository.delete(category.get());
        }
    }

    public Category updateCategory(Category categoryObject, Long id){
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isEmpty()){
            throw new InformationExistException("category doesnt exist");
        }else {
            categoryObject.setId(id);
            return categoryRepository.save(categoryObject);
        }
    }

    public Category uploadImage(
            @RequestParam("img") MultipartFile img,
            @PathVariable Long id
    ) throws IOException {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new InformationExistException("already exists");
        } else {
            Category categoryObject = category.get();
            categoryObject.setImg(img.getBytes());
            categoryObject.setImgtype(img.getContentType());
            return categoryRepository.save(categoryObject);
        }
    }
}
