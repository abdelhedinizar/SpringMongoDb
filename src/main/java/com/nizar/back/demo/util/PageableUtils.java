package com.nizar.back.demo.util;

import com.nizar.back.demo.dto.input.PaginationInputDto;
import com.nizar.back.demo.sort.SortByInterface;
import com.nizar.back.demo.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;


public final class PageableUtils {

    public PageableUtils() {
    }

    public static <E extends Enum<E> & SortByInterface> Pageable getPageFromInput(PaginationInputDto inputDto, Class<E> sortByEnum){
        int currentPage = inputDto.getCurrentPage(); // Integer.parseInt(inputDto.getCurrentPage());
        int pageSize = Integer.parseInt(inputDto.getPageSize());
        Sort sortFields = getSort(inputDto,sortByEnum);
        return PageRequest.of(currentPage - 1,pageSize, sortFields);
    }

    private static <E extends Enum<E> & SortByInterface> Sort getSort(PaginationInputDto inputDto, Class<E> sortByEnum){
        List<String> inputSortBy = inputDto.getSortBy().stream().map(str -> Enum.valueOf(sortByEnum, str.trim().toUpperCase()).getSortBy()).collect(Collectors.toList());
        Sort sortFilds = Sort.unsorted();
        for(String str : inputSortBy){
            sortFilds = inputDto.getSortOrder().trim().equalsIgnoreCase(SortOrder.DESC.toString()) ? sortFilds.and(Sort.by(str).descending()) : sortFilds.and(Sort.by(str).ascending());
        }
        return sortFilds;
    }
}
