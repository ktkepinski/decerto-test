package com.decerto.test.source.integer;

import com.decerto.test.data.Data;
import com.decerto.test.data.integer.IntegerData;
import com.decerto.test.source.DataSource;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JavaRandomIntegerGeneratorTest {

    @Test
    void getData_ShouldReturnRandomData() {
        DataSource<Integer> dataSource = new JavaRandomIntegerGenerator(new Random(1), 10);

        Data<Integer> result = dataSource.getData();

        assertNotNull(result);
        assertEquals(result.getClass(), IntegerData.class);
        assertEquals(5, result.getData());
    }
}