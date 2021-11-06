package com.uorfood.dao;

import com.uorfood.domain.Products;

import java.util.List;

public interface ProductDao {
    List<Products> getAllProduct();
    void insertProduct(Products products);

}
