package com.AndrzejJarosz.module.synchro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomJokeDto {

    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public RandomJokeDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public RandomJokeDto setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "RandomJokeDto{" +
                "value='" + value + '\'' +
                '}';
    }
}
