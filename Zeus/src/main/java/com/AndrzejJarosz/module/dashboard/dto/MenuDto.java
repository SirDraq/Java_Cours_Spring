package com.AndrzejJarosz.module.dashboard.dto;

public class MenuDto {
    private final String name;
    private final String url;

    public MenuDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
