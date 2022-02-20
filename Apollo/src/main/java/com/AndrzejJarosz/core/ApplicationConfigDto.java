package com.AndrzejJarosz.core;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationConfigDto {

    private String domain;
    private String email;
    private String user;
    private String theme;

    public String getDomain() {
        return domain;
    }

    public ApplicationConfigDto setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ApplicationConfigDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUser() {
        return user;
    }

    public ApplicationConfigDto setUser(String user) {
        this.user = user;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public ApplicationConfigDto setTheme(String theme) {
        this.theme = theme;
        return this;
    }
}
