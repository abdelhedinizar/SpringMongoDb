package com.nizar.back.demo.service.impl;

import com.nizar.back.demo.dao.MyProductRepository;
import com.nizar.back.demo.dto.enums.GenericStatus;
import com.nizar.back.demo.dto.input.product.ProductInputDto;
import com.nizar.back.demo.dto.input.product.SetProductInputDto;
import com.nizar.back.demo.dto.output.GenericOutputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.PaginationSummaryOutputDto;
import com.nizar.back.demo.dto.output.product.ProductOutputDto;
import com.nizar.back.demo.entities.MyProduct;
import com.nizar.back.demo.service.ProductService;
import com.nizar.back.demo.sort.product.ProductSortBy;
import com.nizar.back.demo.util.PageableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {


    public static final int CLAUSE_LIMIT = 1000;

    @Autowired
    private MyProductRepository myProductRepository;

    @Override
    public GenericOutputDto addProducts(SetProductInputDto setProductInputDto) {
        GenericOutputDto setProductSpecOutput = new GenericOutputDto();
        Set<MyProduct> productsToInsert = getProductsToBeInserted(setProductInputDto);
        deleteExistantProducts(productsToInsert);
        insertProducts(productsToInsert);
        setProductSpecOutput.setResultCode(GenericStatus.OK);
        return setProductSpecOutput;
    }

    private Set<MyProduct> getProductsToBeInserted(SetProductInputDto setProductInputDto) {
        Set<MyProduct> products = new HashSet<>();
        setProductInputDto.getProductDtos().stream().forEach(productDto -> {
            MyProduct product = new MyProduct();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            products.add(product);
        });
        return products;
    }

    private List<MyProduct> insertProducts(Set<MyProduct> products) {
        return myProductRepository.saveAll(products);
    }


    private void deleteExistantProducts(Set<MyProduct> products) {
        List<String> productNames = products.stream().map(product ->
                product.getName()).collect(Collectors.toList());
        List<MyProduct> productsTodelete = myProductRepository.findByName(productNames);
        myProductRepository.deleteAll(productsTodelete);

        /*  List<List<MyProduct>> partsIds = Lists.partition(products.stream().collect(Collectors.toList()), CLAUSE_LIMIT);
        for (int i = 0; i < partsIds.size(); i++) {
            myProductRepository.findByName(partsIds.get(i));
        }
        */
    }

    @Override
    public PaginationResultOutputDto<ProductOutputDto> getProducts(ProductInputDto inputDto) {
        Pageable page = PageableUtils.getPageFromInput(inputDto, ProductSortBy.class);
        Page<MyProduct> productPage = myProductRepository.findAll(page);
        List<ProductOutputDto> outputDtoList = productPage.stream().map(ProductOutputDto::new).collect(Collectors.toList());
        PaginationSummaryOutputDto paginationSummaryOutputDto = new PaginationSummaryOutputDto(productPage);
        return new PaginationResultOutputDto<>(paginationSummaryOutputDto, outputDtoList, "products");
    }
}
