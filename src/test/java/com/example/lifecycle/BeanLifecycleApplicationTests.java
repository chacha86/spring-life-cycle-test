package com.example.lifecycle;

import com.example.lifecycle.config.MyConfig;
import com.example.lifecycle.config.Person;
import com.example.lifecycle.config.Person2;
import com.example.lifecycle.config.Person3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class BeanLifecycleApplicationTests {

    @Test
    @DisplayName("콜백 - 홍길동 빈이 생성되고 값이 세팅되지 않는 버전")
    void contextLoads() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
        Person p1 = (Person)ac.getBean("person");
        // 스프링 빈 생명주기 상 객체가 먼저 생성되어 빈 등록된 이후 값이 세팅된다.(setter의 실행이 나중에 된다)
    }

    @Test
    @DisplayName("콜백 - 홍길동 빈이 생성되고 값이 세팅되는 버전")
    void contextLoads2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
        Person2 p1 = (Person2)ac.getBean("person2");
        System.out.println("p1 = " + p1);

        // initializeBean의 afterPropertiesSet() 메서드가 값이 다 세팅된 후 실행된다.
        // 하지만 구식 방식 -> 스프링 인터페이스이기 때문에 스프링에 의존적
    }

    @Test
    @DisplayName("애노테이션을 이용한 콜백")
    void contextLoads3() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
        Person3 p1 = (Person3)ac.getBean("person3");
        System.out.println("p1 = " + p1);

        // @PostConstruct, @PreDestroy를 이용한 방식
    }

    @Test
    @DisplayName("콜백 postConstruct, preDestroy 사용 버전")
    void contextLoads4() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
        Person3 p1 = (Person3)ac.getBean("person3");
        System.out.println("p1 = " + p1);

        // @PostConstruct, @PreDestroy를 이용한 방식
    }
}
