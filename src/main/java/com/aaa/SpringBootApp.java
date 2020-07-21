package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot启动程序
 * @author 淮南King
 */
@SpringBootApplication
@MapperScan("com.aaa.dao")
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class,args);
    }
}
