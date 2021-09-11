package com.hnsdksx.app_counterpartapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hnsdksx.app_counterpartapi.mapper")
public class AppCounterpartApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppCounterpartApiApplication.class, args);
    }

}
