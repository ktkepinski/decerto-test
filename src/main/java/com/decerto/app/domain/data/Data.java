package com.decerto.app.domain.data;

public abstract class Data {

    public String asString() {
        throw new UnimplementedException();
    }

    public int asInt() {
        throw new UnimplementedException();
    }
}
