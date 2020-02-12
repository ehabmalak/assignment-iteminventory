package com.example.ItemsInventory.adapter.repository.impl.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class ItemEntity {

    @Id
    private String itemNo;


    private String name;


    private String description;


    private int qty;


    private int price;


    private String manId;
}
