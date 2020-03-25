package com.empconsole.exceptions.exceptionTypes;

public class EmailUniqueException extends RuntimeException {
    public  EmailUniqueException(String userName) {
        super("This email: '"+userName+"' already exists.");
    }
}
