package com.nizar.back.demo.controller.cont.country;

import com.nizar.back.demo.doc.EnableSwaggerDocForExternalEndpoint;
import com.nizar.back.demo.dto.input.country.CountryInputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.country.CountryOutputDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(value = "CountryService", produces = "application/json", tags = {"Country"})
public interface CountryController {

    @ApiOperation(value = "Country web Service", notes = "", response = String.class, authorizations = {})
    @ApiResponses(value = {@ApiResponse(code = 400, message = "bad request")})
    @EnableSwaggerDocForExternalEndpoint
    ResponseEntity<PaginationResultOutputDto<CountryOutputDto>> getCountries(CountryInputDto inputDto);

}
