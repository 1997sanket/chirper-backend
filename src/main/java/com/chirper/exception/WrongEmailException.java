package com.chirper.exception;

public class WrongEmailException extends RuntimeException {
    public WrongEmailException(String s) {
        super(s);
    }
}
