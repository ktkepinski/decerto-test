package com.decerto.app.application.data.source.integer;

import com.decerto.app.application.data.source.DataSource;
import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class JavaRandomIntegerGenerator implements DataSource {

    private final long id;
    private final Random random;
    private final int upperBound;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return "RandomIntegerGenerator";
    }

    @Override
    public Data getData() {
        return new IntegerData(random.nextInt(upperBound));
    }
}
