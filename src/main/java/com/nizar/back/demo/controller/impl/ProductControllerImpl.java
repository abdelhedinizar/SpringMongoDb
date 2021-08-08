package com.nizar.back.demo.controller.impl;

import com.nizar.back.demo.controller.ProductController;
import com.nizar.back.demo.dto.output.ProductOutputDto;
import com.nizar.back.demo.entities.MyProduct;
import com.nizar.back.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/service")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping("/Product")
    @ResponseBody
    public ResponseEntity addProduct(MyProduct myProduct) {
        ProductOutputDto result = productService.addProduct(myProduct);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }
    @GetMapping("/products")
    public ResponseEntity getProducts(){
        List<MyProduct> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
