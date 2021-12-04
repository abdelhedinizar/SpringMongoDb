package com.nizar.back.demo.sort.product;

import com.nizar.back.demo.sort.SortByInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductSortBy implements SortByInterface {
    ID("name");
    private String sortBy;
}
