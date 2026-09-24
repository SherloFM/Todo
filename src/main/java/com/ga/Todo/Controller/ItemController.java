package com.ga.Todo.Controller;

import com.ga.Todo.Model.Item;
import com.ga.Todo.Service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class ItemController {

    private ItemService itemService;

    @GetMapping("/categories/{categoryID}/recipes")
    public Item createRecipe(
            @PathVariable(value = "categoryID") Long categoryID,
            @RequestBody Item itemeObject
    ){
        return itemService.createItem(categoryID, itemeObject);
    }
}
