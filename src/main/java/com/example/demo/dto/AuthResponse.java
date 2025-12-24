package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private int statusCodeValue;

    public AuthResponse() {}

    public AuthResponse(String token, int statusCodeValue) {
        this.token = token;
        this.statusCodeValue = statusCodeValue;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public int getStatusCodeValue() { return statusCodeValue; }
    public void setStatusCodeValue(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }
}
