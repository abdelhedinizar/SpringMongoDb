package com.nizar.back.demo.dto.input.product;

import com.nizar.back.demo.exception.ErrorConstant;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorConstant.REQUIRED_FIELD)
    private String name;

    @ApiParam(value = "The Price")
    @NotNull(message = ErrorConstant.REQUIRED_FIELD)
    private Integer price = 0;
}
