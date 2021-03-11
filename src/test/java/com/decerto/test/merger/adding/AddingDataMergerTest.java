package com.decerto.test.merger.adding;

import com.decerto.test.data.Data;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AddingDataMergerTest {

    @Test
    void getIdentity() {
        Data<Object> first = Mockito.mock(Data.class);
        Data<Object> second = Mockito.mock(Data.class);

        new AddingDataMerger<>().getIdentity(Arrays.asList(first, second));

        verify(first, times(1)).addingIdentity();
    }

    @Test
    void getAccumulator() {
        Data<Object> first = Mockito.mock(Data.class);
        Data<Object> second = Mockito.mock(Data.class);

        BinaryOperator<Data<Object>> result = new AddingDataMerger<>().getAccumulator();
        result.apply(first, second);

        verify(first, times(1)).add(second);
    }
}