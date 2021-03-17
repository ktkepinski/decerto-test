package com.decerto.app.domain.data.integer;

import com.decerto.app.domain.data.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerDataTest {

    @Test
    void asInt() {
        Data data = new IntegerData(4);

        assertEquals(4, data.asInt());
    }

    @Test
    void asString() {
        Data data = new IntegerData(4);

        assertEquals("4", data.asString());
    }
}