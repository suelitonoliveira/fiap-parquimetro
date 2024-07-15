package com.fiap.parquimetro.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidadorDataFim.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidacaoDataFim {
    String message() default "A data de fim deve ser posterior à data de início";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
