package com.decerto.app.application.data;

import com.decerto.app.domain.data.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    private final DataProvider dataProvider;
    private final DataMergeService dataMergeService;

    public Data getData(List<Long> dataSourcesIds, Long mergeMethodId) {
        List<Data> data = dataProvider.getData(dataSourcesIds);
        return dataMergeService.merge(data, mergeMethodId);
    }
}
