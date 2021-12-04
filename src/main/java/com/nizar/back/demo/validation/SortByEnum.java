package com.nizar.back.demo.validation;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Document
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SortByEnumValidator.class)
public @interface SortByEnum {
    String message() default "Value SortBy inconnue";

    String field() default "sortBy";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
