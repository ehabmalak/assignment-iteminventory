package com.example.ItemsInventory.adapter.repository.impl;

import com.example.ItemsInventory.adapter.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "com.training.item.rds",name = "enabled",matchIfMissing = true)
public class ItemRDSConfiguration {

    @Bean
    public ItemRepository itemRepository(ItemJPARepository itemJPARepository, ModelMapper modelMapper){
        return new ItemRDSRepository(itemJPARepository,modelMapper);
    }
}
