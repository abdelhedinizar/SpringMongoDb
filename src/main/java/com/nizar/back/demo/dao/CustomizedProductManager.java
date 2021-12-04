package com.nizar.back.demo.dao;

import com.nizar.back.demo.entities.MyProduct;

import java.util.List;

public interface CustomizedProductManager {
    public List<MyProduct> findByName(List<String> names);
}
