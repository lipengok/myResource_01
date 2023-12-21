package com.lp.map_demo;

import com.lp.map_demo.config.HttpClientConfig;
import org.apache.http.client.HttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapDemoApplicationTests {

    @Autowired
    HttpClient httpClient;

    @Autowired
    HttpClientConfig httpClientConfig;

    @Test
    void contextLoads() {
        System.out.println(httpClient);
        System.out.println(httpClientConfig.getMaxTotal());
    }

}
