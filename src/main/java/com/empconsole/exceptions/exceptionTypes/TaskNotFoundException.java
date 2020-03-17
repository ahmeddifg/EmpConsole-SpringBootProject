package com.empconsole.exceptions.exceptionTypes;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
        super("This task does not exists !");
    }
}
