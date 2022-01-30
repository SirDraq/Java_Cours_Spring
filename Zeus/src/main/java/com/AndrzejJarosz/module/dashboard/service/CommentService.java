package com.AndrzejJarosz.module.dashboard.service;

import com.AndrzejJarosz.module.dashboard.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {
    public List<CommentDto> getComment(){
        return List.of(
                new CommentDto("admin", "lorem ipusum 1"),
                new CommentDto("michael", "lorem ipusum 2"),
                new CommentDto("marta", "lorem ipusum 3")
        );
    }
}
