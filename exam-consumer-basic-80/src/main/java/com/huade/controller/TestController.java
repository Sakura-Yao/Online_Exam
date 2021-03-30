package com.huade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @PostMapping("/test/test")
    @ResponseBody
    public String test(){
        return "root";
    }

}
