package com.bjpowernode.employment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bjpowernode.employment.mapper")
public class EmploymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmploymentApplication.class, args);
    }

}
