package com.decerto.test.config;

import com.decerto.test.source.DataSource;
import com.decerto.test.source.integer.JavaRandomIntegerGenerator;
import com.decerto.test.source.integer.RandomOrgDataSource;
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

    @Bean(name = "javaRandomIntegerGenerator")
    public DataSource<Integer> getJavaRandomIntegerGenerator(Random random) {
        return new JavaRandomIntegerGenerator(random, 100);
    }

    @Bean(name = "randomOrgDataSource")
    public DataSource<Integer> getRandomOrgDataSource(RestTemplate restTemplate) {
        return new RandomOrgDataSource(restTemplate,1, 100);
    }

}