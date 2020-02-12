package com.example.ItemsInventory.adapter.repository.impl;

import com.example.ItemsInventory.adapter.repository.ItemRepository;
import com.example.ItemsInventory.adapter.repository.impl.entity.ItemEntity;
import com.example.ItemsInventory.model.Item;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Component if you want to remove the ItemRDSConfiguration
public class ItemRDSRepository implements ItemRepository {

    private final ItemJPARepository itemJPARepository;
    private final ModelMapper modelMapper;

    public ItemRDSRepository(ItemJPARepository itemJPARepository, ModelMapper modelMapper) {
        this.itemJPARepository = itemJPARepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Item addItem(Item item) {
        itemJPARepository.save(mapToEntity(item));
        return item;
    }

    @Override
    public List<Item> loadItems() {

      return itemJPARepository.findAll()
              .stream()
              .map(this::mapToModel)
              .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> loadItem(String itemNo) {
        return itemJPARepository.findById(itemNo).map(this::mapToModel);
    }

private ItemEntity mapToEntity(Item item){
        return modelMapper.map(item,ItemEntity.class);
}
private Item mapToModel(ItemEntity itemEntity){
        return modelMapper.map(itemEntity,Item.class);
}
}
