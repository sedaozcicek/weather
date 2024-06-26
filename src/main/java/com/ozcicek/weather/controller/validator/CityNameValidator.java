package com.ozcicek.weather.controller.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;
@Component
public class CityNameValidator implements ConstraintValidator<CityNameConstraint,String> {
    @Override
    public void initialize(CityNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        value = value.replace("[^a-zA-Z0-9]", "");
        return !StringUtils.isNumeric(value) && !StringUtils.isAllBlank(value);
    }
}
