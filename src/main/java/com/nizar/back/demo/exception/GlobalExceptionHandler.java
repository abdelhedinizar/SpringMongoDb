package com.nizar.back.demo.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.nizar.back.demo.dto.output.ErrorDetailsDTO;
import com.nizar.back.demo.validation.SortByEnum;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    static final String INTERNAL_SERVER_ERROR_MSG = "Internal server error";
    static final String NOT_DEFINED = "-";

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<CRefError> handlerInternalServerError(Exception ex, WebRequest request) {
        CRefError cRefError = new CRefError();
        List<ErrorDetailsDTO> errorDetailsDTOS = new ArrayList<>();
        HttpStatus httpStatus = INTERNAL_SERVER_ERROR;
        cRefError.setStatus(httpStatus.value());
        cRefError.setErrors(errorDetailsDTOS);
        ErrorDetailsDTO details = new ErrorDetailsDTO(INTERNAL_SERVER_ERROR_MSG, NOT_DEFINED, NOT_DEFINED);
        errorDetailsDTOS.add(details);
        return new ResponseEntity<>(cRefError, new HttpHeaders(), httpStatus);
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<CRefError> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        CRefError cRefError = new CRefError();
        List<ErrorDetailsDTO> errorDetailsDTOS = new ArrayList<>();
        HttpStatus httpStatus = BAD_REQUEST;
        cRefError.setStatus(httpStatus.value());
        cRefError.setErrors(errorDetailsDTOS);
        String field = NOT_DEFINED;
        try {
            List<JsonMappingException.Reference> path = ((MismatchedInputException) ex.getCause()).getPath();
            field = path.get(path.size() - 1).getFieldName();
        }catch ( Exception e) {

        }
        ErrorDetailsDTO details = new ErrorDetailsDTO(ex.getMessage(), NOT_DEFINED, field);
        errorDetailsDTOS.add(details);
        return new ResponseEntity<>(cRefError, new HttpHeaders(), httpStatus);
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<CRefError> handleMethodArgumentNotValid(BindException ex, WebRequest request) {
        CRefError cRefError = new CRefError();
        List<ErrorDetailsDTO> errorDetailsDTOS = new ArrayList<>();
        HttpStatus httpStatus = BAD_REQUEST;
        cRefError.setStatus(httpStatus.value());
        cRefError.setErrors(errorDetailsDTOS);

       ex.getBindingResult().getAllErrors().stream().forEach( objectError -> {
           String field = getField(objectError);
           String codeError = getErrorCode(objectError);
           String errorMessage = objectError.getDefaultMessage();
           ErrorDetailsDTO details = new ErrorDetailsDTO(errorMessage, codeError, field);
           errorDetailsDTOS.add(details);

       });
        return new ResponseEntity<>(cRefError, new HttpHeaders(), httpStatus);
    }

    private String getErrorCode(ObjectError fieldError) {
        ConstraintViolationImpl unwarp = fieldError.unwrap(ConstraintViolationImpl.class);
        String errorMessageTemplate = unwarp.getMessageTemplate();
        HashMap<String,String> result = new HashMap<>();
        return result.get(errorMessageTemplate);
    }

    private String getField(ObjectError objectError) {
        String field = NOT_DEFINED;
        if(objectError instanceof FieldError) {
            field = ((FieldError) objectError).getField();
        } else if(objectError.getCode().equalsIgnoreCase(SortByEnum.class.getSimpleName())) {
            field = objectError.getArguments()[1].toString();
        }
        return field;
    }

}
