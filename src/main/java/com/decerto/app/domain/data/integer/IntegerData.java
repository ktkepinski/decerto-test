package com.decerto.app.domain.data.integer;

import com.decerto.app.domain.data.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IntegerData extends Data {
    @NonNull
    private int value;

    @Override
    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public int asInt() {
        return value;
    }

}
