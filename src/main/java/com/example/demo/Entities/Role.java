package com.example.demo.Entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("USER");

    String p;

    Role(String p) {
        this.p = p;
    }

    @Override
    public String getAuthority() {
        return p;
    }
}
