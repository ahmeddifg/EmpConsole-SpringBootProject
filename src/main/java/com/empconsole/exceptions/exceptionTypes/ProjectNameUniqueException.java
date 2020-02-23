package com.empconsole.exceptions.exceptionTypes;

public class ProjectNameUniqueException extends RuntimeException {
    public ProjectNameUniqueException(String projectName) {
        super("This project name:'"+projectName+"' already exists.");
    }
}
