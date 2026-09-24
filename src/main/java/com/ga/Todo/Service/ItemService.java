package com.ga.Todo.Service;

import com.ga.Todo.Exceptions.InformationExistException;
import com.ga.Todo.Model.Category;
import com.ga.Todo.Model.Item;
import com.ga.Todo.repository.CategoryRepository;
import com.ga.Todo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
