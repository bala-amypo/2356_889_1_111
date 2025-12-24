package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private int statusCode;
    private String message;

    public AuthResponse() {
    }

    // TEST USES THIS CONSTRUCTOR
    public AuthResponse(String token, int statusCode) {
        this.token = token;
        this.statusCode = statusCode;
    }

    // SOME TESTS EXPECT 3 ARGS
    public AuthResponse(String token, int statusCode, String message) {
        this.token = token;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
