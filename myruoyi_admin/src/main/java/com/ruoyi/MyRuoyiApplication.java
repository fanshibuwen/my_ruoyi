package com.ruoyi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.ruoyi.system.mapper"})
public class MyRuoyiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyRuoyiApplication.class, args);
    }
}
