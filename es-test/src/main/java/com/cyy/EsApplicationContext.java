package com.cyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author:CYY
 * @create: 2023-05-23 10:56:50
 * @Description: ES启动类
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class EsApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(EsApplicationContext.class, args);
    }
}