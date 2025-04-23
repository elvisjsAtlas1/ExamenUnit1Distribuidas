package com.eja.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EjaStudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjaStudentServiceApplication.class, args);
    }

}
