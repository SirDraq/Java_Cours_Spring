package com.AndrzejJarosz.module.fragmentsExample.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CmsController {
    @GetMapping({"/cms/page"})
    public String getPage(){
        //noinspection SpringMVCViewInspection
        return "/cms/page.html";
    }
    @GetMapping({"/cms/sub-page"})
    public String getSubPage(){
        //noinspection SpringMVCViewInspection
        return "/cms/sub-page.html";
    }
}
