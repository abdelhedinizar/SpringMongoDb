package com.nizar.back.demo.service;


import com.nizar.back.demo.dto.input.product.ProductInputDto;
import com.nizar.back.demo.dto.input.product.SetProductInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.product.ProductOutputDto;

public interface ProductService {

    GenericOutputDto addProducts(SetProductInputDto productDto);
    PaginationResultOutputDto<ProductOutputDto> getProducts(ProductInputDto inputDto);
}
