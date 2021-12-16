package com.nizar.back.demo.dto.input.user;

import com.nizar.back.demo.dao.country.CountriesRepo;
import com.nizar.back.demo.entities.country.Country;
import com.nizar.back.demo.exception.ErrorConstant;
import com.nizar.back.demo.validation.ExistsInDatabase;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorConstant.REQUIRED_FIELD)
    private String username;

    @NotBlank(message = ErrorConstant.REQUIRED_FIELD)
    private String firstname;

    @NotBlank(message = ErrorConstant.REQUIRED_FIELD)
    private String lastname;

    @NotBlank(message = ErrorConstant.REQUIRED_FIELD)
    @ExistsInDatabase(repository = CountriesRepo.class, field = "countryCode", entityClass = Country.class)
    private String residenceCountryCode;

    @NotBlank(message = ErrorConstant.REQUIRED_FIELD)
    private String profileCode;

}
