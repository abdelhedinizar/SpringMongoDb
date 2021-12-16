package com.nizar.back.demo.sort.user;

import com.nizar.back.demo.sort.SortByInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserSortBy implements SortByInterface {
    ID("username");
    private String sortBy;
}
