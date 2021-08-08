package com.nizar.back.demo.controller;

import com.nizar.back.demo.dto.output.ProductOutputDto;
import com.nizar.back.demo.entities.MyProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(value = "ProductService", produces = "application/json",tags = {"Service"})
public interface ProductController {

    @ApiOperation(value = "Product web Service",notes = "",response = String.class, authorizations = {})
    @ApiResponses(value = {@ApiResponse(code = 400, message = "bad request")})
    ResponseEntity<ProductOutputDto> addProduct(MyProduct myProduct);

}
