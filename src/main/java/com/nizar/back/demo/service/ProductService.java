package com.nizar.back.demo.service;

import com.nizar.back.demo.dto.output.ProductOutputDto;
import com.nizar.back.demo.entities.MyProduct;

import java.util.List;

public interface ProductService {

    ProductOutputDto addProduct(MyProduct product);
    List<MyProduct> getProducts();
}
