package com.example.ItemsInventory.adapter.msg.outbound;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(ItemOutputChannel.class)
public class MessageConfig {
}
