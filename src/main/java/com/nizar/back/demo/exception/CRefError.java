package com.nizar.back.demo.exception;

import com.nizar.back.demo.dto.output.ErrorDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

@Data
@NotBlank
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CRefError {

    private int status;
    private List<ErrorDetailsDTO> errors;

    public CRefError(int status, ErrorDetailsDTO error){
        super();
        this.status =status;
        errors = Arrays.asList(error);
    }
}
