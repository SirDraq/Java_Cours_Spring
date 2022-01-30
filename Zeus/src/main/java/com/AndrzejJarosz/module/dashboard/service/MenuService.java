package com.AndrzejJarosz.module.dashboard.service;

import com.AndrzejJarosz.module.dashboard.dto.MenuDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    public List<MenuDto> getMenu(){
        return  List.of(
                new MenuDto("Home", "/"),
                new MenuDto("Dashboard","/dashboard"),
                new MenuDto("About Us", "/about-us")
        );
    }
}
