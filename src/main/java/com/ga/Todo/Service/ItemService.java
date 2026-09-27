package com.ga.Todo.Service;

import com.ga.Todo.Exceptions.InformationExistException;
import com.ga.Todo.Model.Category;
import com.ga.Todo.Model.Item;
import com.ga.Todo.repository.CategoryRepository;
import com.ga.Todo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    public Item createItem(Long categoryId, Item item){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new InformationExistException("Category with id not found"));
        item.setCategory(category);
        return itemRepository.save(item);
    }

    public Item updateCategory(Long categoryID, Long itemID,Item itemObject){
        Optional<Item> recipe = itemRepository.findById(itemID);
        if(recipe.isEmpty()){
            throw new InformationExistException("recipe doesnt exist");
        }else {
            itemObject.setId(itemID);
            return itemRepository.save(itemObject);
        }
    }

    public void deleteItem(
            @PathVariable Long itemID
    ){
        Optional<Item> recipe = itemRepository.findById(itemID);

        if(recipe.isEmpty()){
            throw new InformationExistException("no file");
        }else{
            itemRepository.delete(recipe.get());
        }
    }
}
