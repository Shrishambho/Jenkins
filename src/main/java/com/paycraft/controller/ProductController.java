package com.paycraft.controller;

import com.paycraft.model.Product;
import com.paycraft.service.ProductIntr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductIntr productIntr;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return new ResponseEntity<>(productIntr.save(product), HttpStatus.OK);
    }
}
