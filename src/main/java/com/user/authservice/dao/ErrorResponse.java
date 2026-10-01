package com.user.authservice.dao;

public class ErrorResponse {

    private long timestamp;
    private int status;
    private String error;
    private String message;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse(int status, String error, String message) {
        this.timestamp = System.currentTimeMillis();
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
