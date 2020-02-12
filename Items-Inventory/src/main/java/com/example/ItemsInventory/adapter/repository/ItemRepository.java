package com.example.ItemsInventory.adapter.repository;


import com.example.ItemsInventory.model.Item;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;


public interface ItemRepository {

    public Item addItem(Item item);

    public List<Item> loadItems();

    public Optional<Item> loadItem(String itemNo);
}
