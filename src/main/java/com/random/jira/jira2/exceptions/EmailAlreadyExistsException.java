package com.random.jira.jira2.exceptions;

public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException() {
        super();
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
