package com.nizar.back.demo.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationSummaryOutputDto {

    private Integer records;
    private Long totalRecords;
    private Integer totalPages;
    private Integer currentPage;

    public PaginationSummaryOutputDto(Page page) {
        records = page.getNumberOfElements();
        totalRecords = page.getTotalElements();
        totalPages = page.getTotalPages();
        currentPage = page.getNumber() + 1;
    }
}
