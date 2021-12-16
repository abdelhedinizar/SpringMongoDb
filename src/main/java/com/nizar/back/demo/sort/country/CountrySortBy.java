package com.nizar.back.demo.sort.country;

import com.nizar.back.demo.sort.SortByInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CountrySortBy implements SortByInterface {
    ID("name");
    private String sortBy;
}
