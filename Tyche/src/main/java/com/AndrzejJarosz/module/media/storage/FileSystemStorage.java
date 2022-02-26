package com.AndrzejJarosz.module.media.storage;

import com.AndrzejJarosz.module.media.reposytory.MediaEntity;
import com.AndrzejJarosz.module.media.reposytory.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileSystemStorage {

    @Autowired
    private MediaRepository mediaRepository;

    @Value("${mediaRootLocation}")
    private String path;

    public void store(MultipartFile file){

        try {
            Path destinationFile = Paths.get(path)
                    .resolve(Paths.get(file.getOriginalFilename()))
                    .normalize()
                    .toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            mediaRepository.save(
                    new MediaEntity(file.getOriginalFilename())
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MediaEntity> list(){
        return mediaRepository.findAll();
    }
}
