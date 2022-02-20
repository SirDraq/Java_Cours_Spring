package com.AndrzejJarosz.module.config.location;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"local","default"})
public class ApplicationConfigLocalService implements ApplicationConfigService{

    @Override
    public String getLocation() {
        return "Gdańsk";
    }
}
