package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/sbb")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }

}
