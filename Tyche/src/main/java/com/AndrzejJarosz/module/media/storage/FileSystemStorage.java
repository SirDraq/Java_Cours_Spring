package com.AndrzejJarosz.module.media.storage;

import com.AndrzejJarosz.module.media.reposytory.MediaEntity;
import com.AndrzejJarosz.module.media.reposytory.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemStorage.class);

    @Value("${mediaRootLocation}")
    private String path;

    public String getFileFullPath(String uuid){
        MediaEntity media = mediaRepository.findOneByUuid(uuid);
        return String.format("%s/%s", path, media.getFileName());

    }

    public void store(MultipartFile file){
        LOGGER.info("File {} uploading", file.getOriginalFilename());
        try {
            Path destinationFile = Paths.get(path)
                    .resolve(Paths.get(file.getOriginalFilename()))
                    .normalize()
                    .toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            LOGGER.info("File {} upload", file.getOriginalFilename());
            mediaRepository.save(
                    new MediaEntity(file.getOriginalFilename())
            );
            LOGGER.info("Metadata saved");
        } catch (IOException e) {
            LOGGER.error("File {}, saving failed", e.getMessage());
            e.printStackTrace();
        }
    }

    public List<MediaEntity> list(){
        return mediaRepository.findAll();
    }
}
