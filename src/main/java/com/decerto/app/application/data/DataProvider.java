package com.decerto.app.application.data;

import com.decerto.app.application.data.source.DataSource;
import com.decerto.app.domain.data.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataProvider {
    private final List<DataSource> dataSources;

    public List<Data> getData(List<Long> dataSourcesIds) {
        return dataSources.stream()
                .filter(dataSource -> dataSourcesIds.contains(dataSource.getId()))
                .map(this::getData)
                .collect(Collectors.toList());
    }

    private Data getData(DataSource dataSource) {
        Data data = dataSource.getData();
        log.info("Received data: {} using data source: {}", data, dataSource.getName());
        return data;
    }
}
