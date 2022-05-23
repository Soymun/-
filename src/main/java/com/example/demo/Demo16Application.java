package com.example.demo;

import com.example.demo.Entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo16Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo16Application.class, args);
    }

    @Bean
    public SessionFactory getSessionFactory(){
        return new Configuration()
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

}
