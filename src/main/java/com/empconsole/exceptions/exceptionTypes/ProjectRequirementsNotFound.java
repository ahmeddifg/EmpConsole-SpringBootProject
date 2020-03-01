package com.empconsole.exceptions.exceptionTypes;

public class ProjectRequirementsNotFound extends RuntimeException {
    public ProjectRequirementsNotFound() {
        super("Project requirement not found.");
    }
}
