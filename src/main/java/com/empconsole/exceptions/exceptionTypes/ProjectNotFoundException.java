package com.empconsole.exceptions.exceptionTypes;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException() {
        super("This project does not exists !");
    }
}
