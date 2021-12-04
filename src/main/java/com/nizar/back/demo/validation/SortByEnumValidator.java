package com.nizar.back.demo.validation;

import com.nizar.back.demo.dto.input.PaginationInputDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SortByEnumValidator implements ConstraintValidator<SortByEnum, PaginationInputDto> {
    @Override
    public boolean isValid(PaginationInputDto inputDto, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        if(inputDto.getSortBy() != null){
            isValid = inputDto.getSortBy().stream().allMatch(sortByElement -> true);
        }

      return isValid;
    }
}
