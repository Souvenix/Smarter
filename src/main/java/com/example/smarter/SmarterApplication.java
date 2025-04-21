package com.example.smarter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.smarter")
@MapperScan("com.example.smarter.mapper")
public class SmarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmarterApplication.class, args);
    }

}
