package com.example.smarter.annotation;

import com.example.smarter.util.validator.QueryUserDTOTimeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Souvenix
 * @time 2025/4/20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QueryUserDTOTimeValidator.class)
public @interface ValidTime {
    String message() default "时间范围无效";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
