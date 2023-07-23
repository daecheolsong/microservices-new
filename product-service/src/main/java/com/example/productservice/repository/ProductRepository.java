package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author daecheol song
 * @since 2023-07-23
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
