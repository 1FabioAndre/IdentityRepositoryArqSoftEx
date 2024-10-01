package com.example.IdentityService;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Identity {
    @Id
    private String ci;

    public Identity() {}

    public Identity(String ci) {
        this.ci = ci;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
}

