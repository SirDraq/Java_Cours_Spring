package com.AndrzejJarosz.module.user.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompanyValidator implements ConstraintValidator<CompanyConstraint, String> {
    @Override
    public void initialize(CompanyConstraint contactNumber) {
    }
    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField != null && contactField.equalsIgnoreCase("dynatrace");
    }
}