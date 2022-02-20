package com.AndrzejJarosz.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${domain}")
    private String domain;

    @Value("${email}")
    private String email;

    @Value("${user}")
    private String user;

    @Value("${theme}")
    private String theme;

    public ApplicationConfigDto asDto(){
        return new ApplicationConfigDto()
                .setDomain(domain)
                .setEmail(email)
                .setUser(user)
                .setTheme(theme);
    }
}
