package com.example.filterdemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou11
 * @version 1.0.0
 * @description TODO
 * @date 2021/4/24
 */
@RestController
public class FilterController {

    @RequestMapping ("/filter/1")
    public String reqFilter1(){
        return "hello filter1!";
    }

    @RequestMapping("/filter/2")
    public String reqFilter2(){
        return "hello filter2!";
    }
}
