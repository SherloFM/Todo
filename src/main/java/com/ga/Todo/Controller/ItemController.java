package com.ga.Todo.Controller;

import com.ga.Todo.Model.Item;
import com.ga.Todo.Service.ItemService;
import org.springframework.web.bind.annotation.*;

public class ItemController {

    private ItemService itemService;

    @GetMapping("/categories/{categoryID}/recipes")
    public Item createItem(
            @PathVariable(value = "categoryID") Long categoryID,
            @RequestBody Item itemeObject
    ){
        return itemService.createItem(categoryID, itemeObject);
    }


    @PutMapping("/categories/{category_id}/item/{item_id}/update")
    public Item updateCategory(
            @PathVariable Long category_id,
            @PathVariable Long item_id,
            @RequestBody Item recipeObject
    ){
        return itemService.updateCategory(category_id,item_id,recipeObject);
    }

    @DeleteMapping("/categories/{category_id}/recipes/{item_id}/delete")
    public void updateCategory(
            @PathVariable Long item_id

    ){
        itemService.deleteItem(item_id);
    }
}
