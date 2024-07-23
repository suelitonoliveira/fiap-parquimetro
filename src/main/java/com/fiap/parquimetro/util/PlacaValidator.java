package com.fiap.parquimetro.util;

import java.util.regex.Pattern;

public class PlacaValidator {

    private static final String PLACA_ANTIGA_REGEX = "^[A-Z]{3}-[0-9]{4}$";
    private static final String PLACA_MERCOSUL_REGEX = "^[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}$";

    private static final Pattern PLACA_ANTIGA_PATTERN = Pattern.compile(PLACA_ANTIGA_REGEX);
    private static final Pattern PLACA_MERCOSUL_PATTERN = Pattern.compile(PLACA_MERCOSUL_REGEX);

    public static boolean isValid(String placa) {
        return PLACA_ANTIGA_PATTERN.matcher(placa).matches() || PLACA_MERCOSUL_PATTERN.matcher(placa).matches();
    }
}
