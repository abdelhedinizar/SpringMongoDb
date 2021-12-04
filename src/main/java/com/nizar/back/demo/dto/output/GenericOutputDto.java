package com.nizar.back.demo.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nizar.back.demo.dto.enums.GenericStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class GenericOutputDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private GenericStatus resultCode;
}
