package com.AndrzejJarosz.module.dashboard.service;

import com.AndrzejJarosz.module.dashboard.dto.ArticleDto;
import com.AndrzejJarosz.module.dashboard.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleService {

    @Autowired
    private CommentService commentService;
    public ArticleDto getArticle(){
        List<CommentDto> comments = commentService.getComment();
        return new ArticleDto()
                .setTitle("First")
                .setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum quis mattis ligula. Nulla eu arcu dictum, dictum nibh at, aliquam nibh. Integer volutpat elit quis nisl ultrices condimentum. Sed augue felis, efficitur nec fermentum vel, gravida nec diam. Vivamus vel quam facilisis, mollis ipsum at, elementum libero. Pellentesque gravida, purus in condimentum malesuada, nisi erat ornare dui, non vulputate mauris tellus quis lacus. Cras ac blandit libero. Praesent gravida vulputate purus consectetur maximus. Nunc vestibulum blandit nunc, eget viverra neque scelerisque eu. Aliquam varius sollicitudin augue, ac fermentum turpis bibendum sit amet. Aenean consectetur nulla sed interdum convallis. Sed sit amet risus vitae purus sodales finibus sit amet non nisi. Quisque fringilla dignissim lectus, a bibendum dolor tincidunt sit amet. Aliquam id lorem vitae leo molestie tincidunt eget accumsan sapien. Ut tincidunt id elit et lacinia.")
                .setComments(comments);

    }
}
