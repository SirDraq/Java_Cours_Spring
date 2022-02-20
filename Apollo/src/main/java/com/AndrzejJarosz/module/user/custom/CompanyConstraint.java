package com.AndrzejJarosz.module.user.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CompanyValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CompanyConstraint {
    String message() default "Invalid company";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}