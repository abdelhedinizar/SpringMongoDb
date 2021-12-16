package com.nizar.back.demo.dto.input.country;

import com.nizar.back.demo.dto.input.PaginationInputDto;
import com.nizar.back.demo.sort.country.CountrySortBy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CountryInputDto extends PaginationInputDto {

    public CountryInputDto() {
        super(CountrySortBy.class);
    }
}
