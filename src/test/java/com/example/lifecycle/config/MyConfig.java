package com.example.lifecycle.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class MyConfig {

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("홍길동");
        person.setAge(20);

        return person;
    }

    @Bean
    public Person2 person2() {
        Person2 person2 = new Person2();
        person2.setName("홍길동");
        person2.setAge(20);

        return person2;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Person3 person3() {
        Person3 person3 = new Person3();
        person3.setName("이순신");
        person3.setAge(22);

        return person3;
    }

    @Bean
    public Person4 person4() {
        Person4 person4 = new Person4();
        person4.setName("강감찬");
        person4.setAge(25);

        return person4;
    }
}
