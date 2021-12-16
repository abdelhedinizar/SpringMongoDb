package com.nizar.back.demo.service.impl.country;


import com.nizar.back.demo.dao.country.CountriesRepo;
import com.nizar.back.demo.dto.input.country.CountryInputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.PaginationSummaryOutputDto;
import com.nizar.back.demo.dto.output.country.CountryOutputDto;
import com.nizar.back.demo.entities.country.Country;
import com.nizar.back.demo.service.country.CountryService;
import com.nizar.back.demo.sort.country.CountrySortBy;
import com.nizar.back.demo.util.PageableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountriesRepo countriesRepo;

    @Override
    public PaginationResultOutputDto<CountryOutputDto> getCountries(CountryInputDto inputDto) {
        Pageable page = PageableUtils.getPageFromInput(inputDto, CountrySortBy.class);
        Page<Country> countryPage = countriesRepo.findAll(page);
        List<CountryOutputDto> outputDtoList = countryPage.stream().map(CountryOutputDto::new).collect(Collectors.toList());
        PaginationSummaryOutputDto paginationSummaryOutputDto = new PaginationSummaryOutputDto(countryPage);
        return new PaginationResultOutputDto<>(paginationSummaryOutputDto, outputDtoList, "countries");
    }
}
