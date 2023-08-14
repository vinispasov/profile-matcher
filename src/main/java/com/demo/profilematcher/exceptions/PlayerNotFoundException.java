package com.demo.profilematcher.exceptions;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
