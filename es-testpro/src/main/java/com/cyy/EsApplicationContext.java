package com.cyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author:CYY
 * @create: 2023-05-23 15:07:23
 * @Description:
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.cyy.mapper.**")
@EnableElasticsearchRepositories
public class EsApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(EsApplicationContext.class, args);
    }
}
