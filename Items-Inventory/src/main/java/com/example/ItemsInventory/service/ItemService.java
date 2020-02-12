package com.example.ItemsInventory.service;

import com.example.ItemsInventory.adapter.msg.outbound.ItemOutputChannel;
import com.example.ItemsInventory.adapter.repository.ItemRepository;
import com.example.ItemsInventory.events.ItemAddedEvent;
import com.example.ItemsInventory.model.Item;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
        private final ItemRepository itemRepository;
        private final ItemOutputChannel itemOutputChannel;

    public ItemService(ItemRepository itemRepository, ItemOutputChannel itemOutputChannel) {
        this.itemRepository = itemRepository;
        this.itemOutputChannel = itemOutputChannel;
    }

    public Item addItem(Item item){

        Item itemAdded = itemRepository.addItem(item);

        ItemAddedEvent itemAddedEvent = ItemAddedEvent.builder()
                .itemNo(item.getItemNo())
                .name(item.getName())
                .price(item.getPrice())
                .qty(item.getQty())
                .build();

        //create Msg
        Message<ItemAddedEvent> itemAddedEventMessage = MessageBuilder.withPayload(itemAddedEvent).build();

        itemOutputChannel.output().send(itemAddedEventMessage);

        return itemAdded;
    }


    public Optional<Item> loadItemByItemNo(String itemNo){

        return itemRepository.loadItem(itemNo);
    }

    public List<Item> loadItems(){
        return itemRepository.loadItems();
    }
}
