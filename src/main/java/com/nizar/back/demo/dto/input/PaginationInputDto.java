package com.nizar.back.demo.dto.input;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nizar.back.demo.validation.SortByEnum;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SortByEnum
public abstract class PaginationInputDto {

    public static final Integer DEFAULT_CURRENT_PAGE = 1;
    public static final String MAX_PAGE_SIZE = "1000";

    @ApiParam(value = "Page de résultats à afficher")
    @Positive(message = "Current page doit etre possitive")
    private Integer currentPage;

    @ApiParam(value = "Nombre de résultats par page")
    @Positive(message = "page size doit etre possitive")
    private String pageSize;

    @ApiParam(value = "Propriété sur laquelle le tri doit s'appliquer")
    private List<String> sortBy;

    @JsonIgnore
    @ApiModelProperty(hidden = true,example = "Name")
    private Class<? extends Enum> sortByEnum;

    @Pattern(regexp = "(?i)ASC|DESC", message = "Valeur SortOrder Inconnue")
    @ApiParam(value = "ordre dans lequel le tri doit s'effectuer")
    private String sortOrder;

    public PaginationInputDto(Class<? extends Enum> sortByEnum) {
        this.sortByEnum = sortByEnum;
        this.pageSize = MAX_PAGE_SIZE;
        this.currentPage = DEFAULT_CURRENT_PAGE;
        this.sortBy = Arrays.asList("ID");
        this.sortOrder = "ASC";
    }
}
