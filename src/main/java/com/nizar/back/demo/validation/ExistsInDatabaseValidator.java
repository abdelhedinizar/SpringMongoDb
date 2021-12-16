package com.nizar.back.demo.validation;


import com.nizar.back.demo.dao.ExistsInDatabaseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsInDatabaseValidator implements ConstraintValidator<ExistsInDatabase, Object> {

    @Autowired
    private ApplicationContext context;

    private ExistsInDatabase existsInDatabase;


    @Override
    public void initialize(ExistsInDatabase constraintAnnotation) {
        this.existsInDatabase = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        if (null != value && !isAnEmptyString(value)) {
            ExistsInDatabaseRepository<?> validationRepository = (ExistsInDatabaseRepository) context.getBean(this.existsInDatabase.repository());
            Long nbItemInDb = validationRepository.countItemByFieldValue(value, this.existsInDatabase.field(), this.existsInDatabase.entityClass());
            isValid = nbItemInDb > 0;
        }
        return isValid;
    }

    private boolean isAnEmptyString(Object value) {
        boolean isStringAndEmpty = false;
        if (null != value && String.class.getName().equals(value.getClass().getName())) {
            isStringAndEmpty = StringUtils.isBlank((String) value);
        }
        return isStringAndEmpty;
    }
}
