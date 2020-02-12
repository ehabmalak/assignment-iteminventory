package com.example.ItemsInventory.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    @NotNull
    private String itemNo;

    @NotNull
    private String name;

    @NotEmpty
    private String description;

    @Min(0)
    private int qty;

    @Min(0)
    private int price;

    @NotEmpty
    private String manId;
}
