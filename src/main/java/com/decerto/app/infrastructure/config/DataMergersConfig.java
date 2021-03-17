package com.decerto.app.infrastructure.config;

import com.decerto.app.domain.data.merger.DataMerger;
import com.decerto.app.domain.data.merger.adding.AddingDataMerger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataMergersConfig {

    @Bean
    public DataMerger getAddingDataMerger() {
        return new AddingDataMerger(1);
    }
}
