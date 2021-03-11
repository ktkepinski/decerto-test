package com.decerto.test.source.integer;

import com.decerto.test.data.Data;
import com.decerto.test.data.integer.IntegerData;
import com.decerto.test.source.DataSource;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class JavaRandomIntegerGenerator implements DataSource<Integer> {

    private final Random random;
    private final int upperBound;

    @Override
    public Data<Integer> getData() {
        return new IntegerData(random.nextInt(upperBound));
    }
}
