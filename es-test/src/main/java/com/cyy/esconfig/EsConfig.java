package com.cyy.esconfig;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:CYY
 * @create: 2023-05-23 09:54:09
 * @Description: 配置es客户端配置类
 */
@Configuration
public class EsConfig {
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.11.131", 9200, "http")));
        return client;
    }

}
