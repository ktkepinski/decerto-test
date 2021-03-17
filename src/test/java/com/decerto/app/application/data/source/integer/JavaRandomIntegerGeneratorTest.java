package com.decerto.app.application.data.source.integer;


import com.decerto.app.application.data.source.DataSource;
import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JavaRandomIntegerGeneratorTest {

    @Test
    void getId() {
        DataSource dataSource = new JavaRandomIntegerGenerator(1, new Random(1), 10);

        assertEquals(1, dataSource.getId());
    }

    @Test
    void getData_ShouldReturnRandomData() {
        DataSource dataSource = new JavaRandomIntegerGenerator(1, new Random(1), 10);

        Data result = dataSource.getData();

        assertNotNull(result);
        assertEquals(result.getClass(), IntegerData.class);
        assertEquals(5, result.asInt());
    }
}