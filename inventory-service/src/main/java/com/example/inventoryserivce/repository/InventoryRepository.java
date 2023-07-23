package com.example.inventoryserivce.repository;

import com.example.inventoryserivce.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author daecheol song
 * @since 2023-07-23
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    List<Inventory> findBySkuCodeIn(List<String> skuCodeList);
}
