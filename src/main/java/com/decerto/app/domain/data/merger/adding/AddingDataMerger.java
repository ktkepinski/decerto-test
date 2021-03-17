package com.decerto.app.domain.data.merger.adding;

import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
import com.decerto.app.domain.data.merger.DataMerger;

import java.util.function.BinaryOperator;

public class AddingDataMerger extends DataMerger {

    private final long id;

    public AddingDataMerger(long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    protected Data getIdentity() {
        return new IntegerData(0);
    }

    @Override
    protected BinaryOperator<Data> getAccumulator() {
        return (a,b) -> new IntegerData(a.asInt() + b.asInt());
    }
}
