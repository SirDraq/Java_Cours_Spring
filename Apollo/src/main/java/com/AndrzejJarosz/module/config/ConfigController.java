package com.AndrzejJarosz.module.config;

import com.AndrzejJarosz.core.ApplicationConfig;
import com.AndrzejJarosz.module.config.location.ApplicationConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigController {

    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private ApplicationConfigService applicationConfigService;

    @GetMapping("/config")
    public String getConfig(Model model){
        model.addAttribute(
                "config",
                applicationConfig.asDto()
        );
        model.addAttribute(
                "location",
                applicationConfigService.getLocation()
        );
        return "config.html";
    }
}
