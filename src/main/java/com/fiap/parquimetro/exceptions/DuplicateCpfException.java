package com.fiap.parquimetro.exceptions;

public class DuplicateCpfException extends RuntimeException{
    public DuplicateCpfException(String message){
        super(message);
    }
}
