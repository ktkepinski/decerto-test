package com.decerto.test.data;

import lombok.ToString;

@ToString(onlyExplicitlyIncluded = true, includeFieldNames = false)
public abstract class Data<T> {
    @ToString.Include
    public abstract T getData();

    public Data<T> add(Data<T> other) {
        throw new UnimplementedException();
    }

    public Data<T> addingIdentity() {
        throw new UnimplementedException();
    }
}
