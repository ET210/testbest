package com.cyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author:CYY
 * @create: 2023-06-05 20:07:21
 * @Description:
 */
@EnableAsync
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class StreamApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(StreamApplicationContext.class, args);
    }
}
