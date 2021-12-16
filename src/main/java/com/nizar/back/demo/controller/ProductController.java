package com.nizar.back.demo.controller;

import com.nizar.back.demo.doc.EnableSwaggerDocForExternalEndpoint;
import com.nizar.back.demo.dto.input.product.ProductInputDto;
import com.nizar.back.demo.dto.input.product.SetProductInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.product.ProductOutputDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

@Api(value = "ProductService", produces = "application/json", tags = {"Product"})
public interface ProductController {

    @ApiOperation(value = "Product web Service", notes = "", response = String.class, authorizations = {})
    @ApiResponses(value = {@ApiResponse(code = 400, message = "bad request")})
    ResponseEntity<GenericOutputDto> addProducts( @ApiParam("Product to add. Cannot null or empty.") SetProductInputDto setProductInputDto) throws URISyntaxException;

    @ApiOperation(value = "Product web Service", notes = "", response = String.class, authorizations = {})
    @ApiResponses(value = {@ApiResponse(code = 400, message = "bad request")})
    @EnableSwaggerDocForExternalEndpoint
    ResponseEntity<PaginationResultOutputDto<ProductOutputDto>> getProducts(ProductInputDto inputDto);


}
