package com.AndrzejJarosz.module.media.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository
        extends JpaRepository<MediaEntity, Long>,
        JpaSpecificationExecutor<MediaEntity> {
}
