package com.example.rest.service;

import com.example.rest.model.OrderDetail;
import com.example.rest.model.Orders;
import com.example.rest.model.Product;
import com.example.rest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ProductService {
    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ArrayList<Product> getAllProductStock() {
        return productRepository.findAllByInStock(true);
    }
}
