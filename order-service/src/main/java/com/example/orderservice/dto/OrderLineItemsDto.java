package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author daecheol song
 * @since 2023-07-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderLineItemsDto {

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;
}
