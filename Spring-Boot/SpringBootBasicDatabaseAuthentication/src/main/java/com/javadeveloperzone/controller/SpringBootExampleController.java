package com.javadeveloperzone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
public class SpringBootExampleController {

    @RequestMapping("/")
    public String SpringBootHello() {
        return "spring boot basic authentication database";
    }
}
