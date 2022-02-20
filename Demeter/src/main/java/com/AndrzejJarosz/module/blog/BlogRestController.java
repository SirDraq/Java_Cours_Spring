package com.AndrzejJarosz.module.blog;

import com.AndrzejJarosz.module.blog.menu.MenuDto;
import com.AndrzejJarosz.module.blog.menu.MenuService;
import com.AndrzejJarosz.module.blog.post.PostDto;
import com.AndrzejJarosz.module.blog.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private PostService postService;

    @GetMapping("/api/blog/menu")
    public List<MenuDto> getMenus(){
        return menuService.getMenu();
    }
    @GetMapping("/api/blog/post")
    public List<PostDto> getPosts(){
        return postService.getPosts();
    }
}
