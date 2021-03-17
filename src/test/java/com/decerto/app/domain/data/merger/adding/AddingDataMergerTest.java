package com.decerto.app.domain.data.merger.adding;

import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
import com.decerto.app.domain.data.merger.DataMerger;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddingDataMergerTest {

    @Test
    void getId() {
        DataMerger merger = new AddingDataMerger(1);

        assertEquals(1, merger.getId());
    }

    @Test
    void getIdentity() {
        Data identity = new AddingDataMerger(1).getIdentity();

        assertEquals(new IntegerData(0), identity);
    }

    @Test
    void getAccumulator() {
        BinaryOperator<Data> accumulator = new AddingDataMerger(1).getAccumulator();

        assertEquals(new IntegerData(5), accumulator.apply(new IntegerData(2), new IntegerData(3)));
    }
}