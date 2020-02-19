package com.empconsole.exceptions.exceptionTypes;

import java.util.function.Supplier;

public class LoginExceptionException extends RuntimeException {
    public LoginExceptionException() {
        super("Error on your User Name/Email or password !!");
    }
}
