package com.nizar.back.demo.validation;

import com.nizar.back.demo.dao.ExistsInDatabaseRepository;
import com.nizar.back.demo.exception.ErrorConstant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ExistsInDatabaseValidator.class)
public @interface ExistsInDatabase {

    String message() default ErrorConstant.UNKNOWN_FIELD;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends ExistsInDatabaseRepository> repository();

    String field();

    Class<?> entityClass();
}
