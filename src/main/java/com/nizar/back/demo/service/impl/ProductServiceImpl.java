package com.nizar.back.demo.service.impl;

import com.nizar.back.demo.dao.MyProductRepository;
import com.nizar.back.demo.dto.output.ProductOutputDto;
import com.nizar.back.demo.entities.MyProduct;
import com.nizar.back.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MyProductRepository myProductRepository;

    @Override
    public ProductOutputDto addProduct(MyProduct product) {
        return new ProductOutputDto(myProductRepository.insert(product));
    }

    @Override
    public List<MyProduct> getProducts() {
        return myProductRepository.findAll();
    }
}
