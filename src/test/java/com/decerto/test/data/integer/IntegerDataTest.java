package com.decerto.test.data.integer;

import com.decerto.test.data.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerDataTest {

    @Test
    void add() {
        Data<Integer> first = new IntegerData(4);
        Data<Integer> second = new IntegerData(5);

        Data<Integer> result = first.add(second);

        assertEquals(9, result.getData());
    }

    @Test
    void addingIdentity() {
        Data<Integer> first = new IntegerData(4);

        Data<Integer> result = first.addingIdentity();

        assertEquals(0, result.getData());
    }
}