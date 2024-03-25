package com.example.lifecycle.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Person4 {
    private String name;
    private int age;

    public Person4() {
        System.out.println("사람이 생성됩니다.");
    }


    public void introduce() {
        System.out.println("안녕하세요, 저는 " + name + "이고, " + age + "살입니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init() {
        introduce();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("사람이 소멸됩니다.");
    }
}
