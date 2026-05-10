package com.ablis.app.exception;

public class ErrorResponse {

    private final String error;
    private final int status;

    public ErrorResponse(String error, int status) {
        this.error = error;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }
}
