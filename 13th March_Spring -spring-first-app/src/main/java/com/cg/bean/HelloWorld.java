package com.cg.bean;

import java.util.List;

public class HelloWorld {
    private String name;
    private List<String> language;

    public HelloWorld() {
    }

    public HelloWorld(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String sayHello(){
        return "Hello " + name.toUpperCase() + "!";
    }
}
