package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by JavaDeveloperZone on 06-05-2018.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "Spring boot YML Example";
    }
}