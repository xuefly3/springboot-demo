package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.example.demo.mapper")
@EnableScheduling
@EnableTransactionManagement
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        log.info("DemoApplication run enter...");
        SpringApplication.run(DemoApplication.class, args);
    }

}
