package com.decerto.app.infrastructure.config;

import com.decerto.app.application.data.source.DataSource;
import com.decerto.app.application.data.source.integer.JavaRandomIntegerGenerator;
import com.decerto.app.application.data.source.integer.RandomOrgDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Configuration
public class IntegerDataSourceConfiguration {

    @Bean
    public Random getRandom() {
        return new Random();
    }

    @Bean
    public DataSource getJavaRandomIntegerGenerator(Random random) {
        return new JavaRandomIntegerGenerator(1,random, 100);
    }

    @Bean
    public DataSource getRandomOrgDataSource(RestTemplate restTemplate) {
        return new RandomOrgDataSource(restTemplate, 2,1, 100);
    }

}