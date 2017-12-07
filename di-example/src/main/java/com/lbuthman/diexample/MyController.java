package com.lbuthman.diexample;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String hello() {
        System.out.println("Hello squirrel!");
        return "foo";
    }
}
