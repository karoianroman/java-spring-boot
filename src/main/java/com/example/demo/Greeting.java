package com.example.demo;

public class Greeting {
    private String message;
    private String version;

    public Greeting(String message, String version) {
        this.message = message;
        this.version = version;
    }

    public String getMessage() { return message; }
    public String getVersion() { return version; }
}