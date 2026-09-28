package com.ga.Todo.Service;

import com.ga.Todo.Exceptions.InformationExistException;
import com.ga.Todo.Model.Category;
import com.ga.Todo.Model.User;
import com.ga.Todo.repository.CategoryRepository;
import com.ga.Todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {


    private CategoryRepository categoryRepository;

    private static User getCurrentLoggedInUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDetails.getUser();
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }


    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public String hello(){
        return "Hello World!";
    }

    public List<Category> getCategories(){
        return categoryRepository.findByUserId(getCurrentLoggedInUser().getId());
    }


    public Category getCategories(
            Long chosen
    ){
        Category category = categoryRepository.findByUserIdAndId(getCurrentLoggedInUser().getId(),chosen);
        return category;
    }


    public Category addCategories(Category categoryObject){
        Category category = categoryRepository.findByUserIdAndName(getCurrentLoggedInUser().getId(), categoryObject.getName());
        categoryObject.setUser(getCurrentLoggedInUser());
        if (category != null) {
            throw new InformationExistException("already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }


    public void deleteCategory(
            @PathVariable Long id
    ){
        Category category = categoryRepository.findByUserIdAndId(getCurrentLoggedInUser().getId(),id);
        if(category == null){
            throw new InformationExistException("no file");
        }else{
            categoryRepository.delete(category);
        }
    }

    public Category updateCategory(Category categoryObject, Long id){
        Category category = categoryRepository.findByUserIdAndId(getCurrentLoggedInUser().getId(), id);

        if(category == null){
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
