package com.AndrzejJarosz.module.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    //@GetMapping("/") <-- without {} if only one path is given
    @GetMapping({"/", "/home", "/index.html", "/index.php"})
    public String getHome(Model model){
        //string
        model.addAttribute("name","Andrzej");
        model.addAttribute("surname","Jarosz");
        //obj
        model.addAttribute("person",new PersonDto("Andrzej","Jarosz",21));
        //list
        List<Object> persons = new ArrayList();
        persons.addAll(Arrays.asList(new PersonDto("Jan", "Kowalski", 00), new PersonDto("Ivan", "Ivanowicz", 21), new PersonDto("I'have", "no idea", 00)));
        model.addAttribute("persons",persons);
        return "home/index.html";
    }
}
