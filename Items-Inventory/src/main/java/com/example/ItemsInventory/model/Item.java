package com.example.ItemsInventory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

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
