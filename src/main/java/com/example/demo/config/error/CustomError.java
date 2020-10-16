package com.example.demo.config.error;

public class CustomError {
    private String message;
    private int value;

    public CustomError(){

    }

    public CustomError(String message, int value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomError{" +
                "message='" + message + '\'' +
                ", value=" + value +
                '}';
    }
}
