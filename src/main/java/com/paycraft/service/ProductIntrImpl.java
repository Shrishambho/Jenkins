package com.paycraft.service;

import com.paycraft.model.Product;
import com.paycraft.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductIntrImpl implements ProductIntr{

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){

        return productRepository.save(product);


    }
}
