package com.nizar.back.demo.service.country;

import com.nizar.back.demo.dto.input.country.CountryInputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.country.CountryOutputDto;

public interface CountryService {
    PaginationResultOutputDto<CountryOutputDto> getCountries(CountryInputDto inputDto);
}
