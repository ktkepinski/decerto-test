package com.decerto.app.domain.data.merger;


import com.decerto.app.domain.data.Data;

import java.util.List;
import java.util.function.BinaryOperator;

public abstract class DataMerger {

    public abstract Long getId();

    public Data merge(List<Data> dataList) {
        return dataList.stream()
                .reduce(getIdentity(), getAccumulator());
    }

    protected abstract Data getIdentity();

    protected abstract BinaryOperator<Data> getAccumulator();
}
