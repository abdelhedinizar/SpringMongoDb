package com.nizar.back.demo.dto.output.country;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nizar.back.demo.entities.country.Country;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CountryOutputDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;

    public CountryOutputDto(Country country){
        name = country.getCountryName();
        code = country.getCountryCode();
    }
}
