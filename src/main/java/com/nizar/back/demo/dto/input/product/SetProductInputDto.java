package com.nizar.back.demo.dto.input.product;

import com.nizar.back.demo.exception.ErrorConstant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SetProductInputDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = ErrorConstant.REQUIRED_FIELD)
    @Valid
    private List<ProductDto> productDtos;
}
