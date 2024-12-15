package com.hyhuang.UMS.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSettingController {

    @RequestMapping("/homepage")
    public String TestForProjectInit(){
        return "Project Setting OK";
    }


}
