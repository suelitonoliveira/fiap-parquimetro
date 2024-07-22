package com.fiap.parquimetro.util;

import com.fiap.parquimetro.dto.SessaoDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class ValidadorDataFim implements ConstraintValidator<ValidacaoDataFim, SessaoDTO> {
    @Override
    public void initialize(ValidacaoDataFim constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SessaoDTO sessaoDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (sessaoDTO == null) {
            return true;
        }

        LocalDateTime inicioSessao = LocalDateTime.now();
        LocalDateTime fimSessao = sessaoDTO.getFimSessao();

        if (fimSessao == null) {
            return true;
        }

        boolean isValid = fimSessao.isAfter(inicioSessao);

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("A data de fim deve ser posterior à data de início")
                    .addPropertyNode("fimSessao")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
