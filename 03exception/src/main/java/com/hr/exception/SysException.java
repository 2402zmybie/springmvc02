package com.hr.exception;

public class SysException extends Exception{

    private String message;

    public SysException(String message) {
        super(message);
    }
}
