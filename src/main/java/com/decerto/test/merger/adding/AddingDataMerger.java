package com.decerto.test.merger.adding;

import com.decerto.test.data.Data;
import com.decerto.test.merger.DataMerger;

import java.util.List;
import java.util.function.BinaryOperator;

public class AddingDataMerger<T> extends DataMerger<T> {

    @Override
    protected Data<T> getIdentity(List<Data<T>> dataList) {
        return dataList.get(0).addingIdentity();
    }

    @Override
    protected BinaryOperator<Data<T>> getAccumulator() {
        return (a, b) -> a.add(b);
    }
}
