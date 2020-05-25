package com.example.appsocisrunapp.info.Model;

public class RunAppException extends RuntimeException{
    public RunAppException() {
    }

    public RunAppException(String message) {
        super(message);
    }

    public RunAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public RunAppException(Throwable cause) {
        super(cause);
    }

    public RunAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
