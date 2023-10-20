package com.example.Model;

public class loginReturn {
    private boolean success;
    private String message;
    
    public loginReturn(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
