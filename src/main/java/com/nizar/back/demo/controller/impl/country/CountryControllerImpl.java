package com.nizar.back.demo.controller.impl.country;

import com.nizar.back.demo.aop.WsLog;
import com.nizar.back.demo.controller.cont.country.CountryController;
import com.nizar.back.demo.dto.input.country.CountryInputDto;
import com.nizar.back.demo.dto.output.PaginationResultOutputDto;
import com.nizar.back.demo.dto.output.country.CountryOutputDto;
import com.nizar.back.demo.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/service")
public class CountryControllerImpl implements CountryController {

    @Autowired
    private CountryService countryService;


    @Override
    @GetMapping("/countries")
    @ResponseBody
    @WsLog(serviceName = "api/dc/countries")
    public ResponseEntity<PaginationResultOutputDto<CountryOutputDto>> getCountries(@Valid CountryInputDto inputDto) {
        PaginationResultOutputDto<CountryOutputDto> result = countryService.getCountries(inputDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
