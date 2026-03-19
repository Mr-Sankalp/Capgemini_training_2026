package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@Controller
//public class HelloController {
//    @GetMapping("map")
//    public @ResponseBody String sayHello() {
//        return "Hello";
//    }
//}

@RestController
public class HelloController {
    @GetMapping("map/{name}") //path variable
    public String sayHello(@PathVariable String name) {
        return "Hello "+name;
    }
    @GetMapping("xyz")
    public String  sayHello1() {
        return "Hello Aniket";
    }
}
