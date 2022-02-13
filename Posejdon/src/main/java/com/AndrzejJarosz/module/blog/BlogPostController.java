package com.AndrzejJarosz.module.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogPostController {

    @Autowired
    private PostMemoryStorageService postMemoryStorageService;

    @RequestMapping(path="/blog/posts", method = RequestMethod.GET)
    public String getPostList(Model model){
        model.addAttribute("postForm", new PostForm());
        model.addAttribute("posts", postMemoryStorageService.list());
        return "blog/posts.html";
    }

    @RequestMapping(path = "/blog/posts", method = RequestMethod.POST)
    public String createPost(PostForm form) {
        PostDto newPost = postMemoryStorageService.create(form);
        return "redirect:/blog/posts/" + newPost.getUuid();
    }

    @RequestMapping(path = "/blog/posts/{uuid}", method = RequestMethod.GET)
    public String getPost(@PathVariable("uuid") String uuid, Model model){
        model.addAttribute("post", postMemoryStorageService.one(uuid));
        return "blog/post";
    }

}
