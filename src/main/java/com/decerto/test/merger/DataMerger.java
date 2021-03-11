package com.decerto.test.merger;

import com.decerto.test.data.Data;

import java.util.List;
import java.util.function.BinaryOperator;

public abstract class DataMerger<T> {

    public Data<T> merge(List<Data<T>> dataList) {
        return dataList.stream()
                .reduce(getIdentity(dataList), getAccumulator());
    }

    protected abstract Data<T> getIdentity(List<Data<T>> dataList);

    protected abstract BinaryOperator<Data<T>> getAccumulator();
}
