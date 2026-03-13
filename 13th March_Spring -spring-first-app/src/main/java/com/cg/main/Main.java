package com.cg.main;

import com.cg.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld h1 = (HelloWorld)ctx.getBean("hello");
        HelloWorld h2 = (HelloWorld)ctx.getBean("hello");

//        System.out.println(h1);
//        System.out.println(h2);
//        System.out.println(h1==h2);

//        h1.setName("Sadiq");
        System.out.println(h1.sayHello());
        System.out.println("=====Language=====");
        System.out.println(h1.getLanguage());

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
