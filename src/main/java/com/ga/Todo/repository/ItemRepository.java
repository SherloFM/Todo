package com.ga.Todo.repository;

import com.ga.Todo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{
    Item findByName(String itemName);
    List<Item> findByCategoryID(Long categoryID);
}
