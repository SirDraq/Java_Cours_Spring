package com.AndrzejJarosz.module.dashboard;

import com.AndrzejJarosz.module.dashboard.service.ArticleService;
import com.AndrzejJarosz.module.dashboard.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/dashboard")
    public String getDashBoard(Model model){

        model.addAttribute("menu",menuService.getMenu());
        model.addAttribute("article",articleService.getArticle());

        return "dashboard/index.html";
    }
}
