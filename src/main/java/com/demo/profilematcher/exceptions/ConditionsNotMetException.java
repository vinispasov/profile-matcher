package com.demo.profilematcher.exceptions;

public class ConditionsNotMetException extends Exception {
    public ConditionsNotMetException(String errorMessage) {
        super(errorMessage);
    }
}
