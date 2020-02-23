package com.empconsole.exceptions.exceptionTypes;

public class UserNameUniqueException extends RuntimeException {
    public UserNameUniqueException(String userName) {
        super("This user name:'"+userName+"' already exists.");
    }
}
