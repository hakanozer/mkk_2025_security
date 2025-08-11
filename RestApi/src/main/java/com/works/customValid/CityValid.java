package com.works.customValid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CityValid implements ConstraintValidator<City, String> {

    String[] cities = {"İstanbul", "Ankara", "Bursa"};

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.asList(cities).contains(s);
    }

}
