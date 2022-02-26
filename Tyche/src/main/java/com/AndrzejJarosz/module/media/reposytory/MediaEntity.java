package com.AndrzejJarosz.module.media.reposytory;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "media")
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String fileName;

    public MediaEntity() {
    }

    public MediaEntity(String fileName) {
        this.uuid = UUID.randomUUID().toString();
        this.fileName = fileName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFileName() {
        return fileName;
    }
}