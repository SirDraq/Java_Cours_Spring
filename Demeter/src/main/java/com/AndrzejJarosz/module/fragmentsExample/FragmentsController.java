package com.AndrzejJarosz.module.fragmentsExample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {
    @GetMapping({"/fragments"})
    public String getFragmentsExample(){
        //noinspection SpringMVCViewInspection
        return "fragmentsExample/index.html";
    }
    @GetMapping({"/fragments/about-me"})
    public String getFragmentsExampleAboutMe(){
        //noinspection SpringMVCViewInspection
        return "fragmentsExample/about-me.html";
    }
}
