package com.example.ItemsInventory.events;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ItemAddedEvent {

    private String itemNo;

    private String name;

    private int qty;

    private int price;
}
