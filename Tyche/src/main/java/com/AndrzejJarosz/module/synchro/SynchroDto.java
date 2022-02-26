package com.AndrzejJarosz.module.synchro;

public class SynchroDto {

    private String status = "OK";

    public String getStatus() {
        return status;
    }

    public SynchroDto setStatus(String status) {
        this.status = status;
        return this;
    }
}
