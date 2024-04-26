package com.foodPlanet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "react/data")
public class ForReactController {
    // http://localhost:8888/react/data/exam01
    // ㅁㅁ
    @GetMapping(value = "/exam01")
    public String getData01() {

        return "aa/bb";
    }
}
