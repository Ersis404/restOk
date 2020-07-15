package com.example.rest.api;

import com.example.rest.model.OrderDetail;
import com.example.rest.model.Product;
import com.example.rest.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/product",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ControllerProduct {
    private final ProductService productService;

    public ControllerProduct(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/getAllProductStock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Product> getAllProductStock(){
        return productService.getAllProductStock();
    }
}
