package com.empconsole.exceptions.exceptionTypes;

import java.util.function.Supplier;

public class LoginException extends RuntimeException {
    public LoginException() {
        super("Error on your User Name/Email or password !!");
    }
}
