package com.decerto.app.application.data;

import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.merger.DataMerger;
import com.decerto.app.domain.data.merger.MergeMethodNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataMergeService {

    private final List<DataMerger> dataMergers;

    public Data merge(List<Data> dataList, Long methodId) {
        DataMerger dataMerger = dataMergers.stream()
                .filter(merger -> merger.getId().equals(methodId))
                .findAny()
                .orElseThrow(MergeMethodNotExistsException::new);
        return dataMerger.merge(dataList);
    }
}
