package com.nizar.back.demo.controller.impl;

import com.nizar.back.demo.aop.WsLog;
import com.nizar.back.demo.controller.ProductController;
import com.nizar.back.demo.dto.input.product.ProductInputDto;
import com.nizar.back.demo.dto.input.product.SetProductInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.product.ProductOutputDto;
import com.nizar.back.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/service")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping("/Product")
    @ResponseBody
    @WsLog(serviceName = "api/dc/product")
    public ResponseEntity<GenericOutputDto> addProducts(@Valid @RequestBody SetProductInputDto setProductInputDto) {
        GenericOutputDto result = productService.addProducts(setProductInputDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/Product")
    @ResponseBody
    @WsLog(serviceName = "api/dc/product")
    public ResponseEntity<PaginationResultOutputDto<ProductOutputDto>> getProducts(@Valid ProductInputDto inputDto) {
        PaginationResultOutputDto<ProductOutputDto> result = productService.getProducts(inputDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}