package com.cyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author:CYY
 * @create: 2023-05-30 20:22:40
 * @Description:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cyy.annotation"})
@ComponentScan(basePackages ={"com.cyy.aop"})
@ComponentScan(basePackages = {"com.cyy.config"})
public class InterfaceDempotencyApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(InterfaceDempotencyApplicationContext.class,args);
    }
}
