package com.random.jira.jira2.exceptions;

public class UserNameAlreadyExistsException extends Exception {

    public UserNameAlreadyExistsException() {
        super();
    }

    public UserNameAlreadyExistsException(String message) {
        super(message);
    }

}
