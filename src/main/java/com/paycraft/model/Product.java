package com.paycraft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
    public class Product {



        @Id
         @GeneratedValue(strategy = IDENTITY)
        private Long id;

        private String productName;

         private Double price;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    }

