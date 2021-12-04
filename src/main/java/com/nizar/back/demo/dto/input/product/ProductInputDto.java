package com.nizar.back.demo.dto.input.product;

import com.nizar.back.demo.dto.input.PaginationInputDto;
import com.nizar.back.demo.sort.product.ProductSortBy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ProductInputDto extends PaginationInputDto {

    public ProductInputDto() {
        super(ProductSortBy.class);
    }
}
