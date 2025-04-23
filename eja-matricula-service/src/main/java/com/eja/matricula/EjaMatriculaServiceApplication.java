package com.eja.matricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EjaMatriculaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjaMatriculaServiceApplication.class, args);
    }

}
