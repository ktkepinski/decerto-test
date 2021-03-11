package com.decerto.test.data.integer;

import com.decerto.test.data.Data;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class IntegerData extends Data<Integer> {
    @NonNull
    private Integer value;

    @Override
    public Integer getData() {
        return value;
    }

    public Data<Integer> add(Data<Integer> other) {
        return new IntegerData(value + other.getData());
    }

    public Data<Integer> addingIdentity() {
        return new IntegerData(0);
    }
}
