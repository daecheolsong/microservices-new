package com.example.inventoryserivce.service;

import com.example.inventoryserivce.dto.InventoryResponse;
import com.example.inventoryserivce.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author daecheol song
 * @since 2023-07-23
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCodeList) {
        // simulate timeout behavior
//        log.info("Wait Started");
//        Thread.sleep(10000);
//        log.info("Wait Ended");

        return inventoryRepository.findBySkuCodeIn(skuCodeList).stream()
                .map(inventory ->
                        InventoryResponse.builder().skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                )
                .toList();
    }
}
