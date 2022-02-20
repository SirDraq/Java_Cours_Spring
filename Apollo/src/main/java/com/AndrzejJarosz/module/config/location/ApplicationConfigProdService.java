package com.AndrzejJarosz.module.config.location;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"prod"})
public class ApplicationConfigProdService implements ApplicationConfigService{
    @Override
    public String getLocation() {
        return "Toruń";
    }
}
