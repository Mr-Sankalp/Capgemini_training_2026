package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@Controller
public class HelloController {
    @GetMapping("map/{n}")  //{path variable}
    public String sayHello(@PathVariable("n") String name){ //name of variable and path var is diff so write as @PathVariable("n")
        return "Hello "+name;
    }
}
