package com.example.ItemsInventory.adapter.repository.impl;


import com.example.ItemsInventory.adapter.repository.impl.entity.ItemEntity;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJPARepository extends JpaRepository<ItemEntity, String> {
}
