package com.example.ItemsInventory.adapter.rest;

import com.example.ItemsInventory.adapter.rest.dto.ItemDTO;
import com.example.ItemsInventory.model.Item;
import com.example.ItemsInventory.service.ItemService;
import org.apache.kafka.common.protocol.types.Field;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ItemDTO addingItem(@RequestBody @Valid ItemDTO itemDTO){
        Item item = mapToModel(itemDTO);
        itemService.addItem(item) ;
            return mapToDTO(item);

    }

    @GetMapping
    public List<ItemDTO> getItems(){
        return itemService.loadItems().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{itemNo}")
    public ItemDTO  getItemByItemNo(@PathVariable("itemNo") String  itemNo){
        return itemService.loadItemByItemNo(itemNo).map(this::mapToDTO).get();
    }


    private Item mapToModel(ItemDTO itemDTO){
        return modelMapper.map(itemDTO,Item.class);
    }

    private ItemDTO mapToDTO(Item item){
        return modelMapper.map(item,ItemDTO.class);
    }


}
