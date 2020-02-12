package com.example.ItemsInventory.adapter.msg.outbound;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ItemOutputChannel {

    String ITEM_ADDED_EVENTS_CHANNEL="item-added-events";

    @Output(ITEM_ADDED_EVENTS_CHANNEL)
    MessageChannel output();
}
