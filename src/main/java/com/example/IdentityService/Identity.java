package com.example.IdentityService;

public class Identity {
    private String ci;
    private String name;

    public Identity(String ci, String name) {
        this.ci = ci;
        this.name = name;
    }

    public String getCi() {
        return ci;
    }

    public String getName() {
        return name;
    }
}