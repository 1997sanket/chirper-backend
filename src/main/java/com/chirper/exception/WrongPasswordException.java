package com.chirper.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String wrongPassword) {
        super(wrongPassword);
    }
}
