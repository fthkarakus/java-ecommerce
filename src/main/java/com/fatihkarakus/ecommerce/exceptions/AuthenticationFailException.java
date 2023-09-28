package com.fatihkarakus.ecommerce.exceptions;

public class AuthenticationFailException extends IllegalArgumentException{
    public AuthenticationFailException(String msg) {
        super(msg);
    }
}
