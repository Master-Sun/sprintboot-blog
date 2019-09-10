package com.kzzf.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
//        int i = 9/0;
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}
