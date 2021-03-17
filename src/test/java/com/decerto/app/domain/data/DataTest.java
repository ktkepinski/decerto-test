package com.decerto.app.domain.data;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DataTest {

    @Test
    public void givenAsStringMethod_whenMockitoMock_throwsException() {
        Data dataContainer = Mockito.mock(Data.class, Mockito.CALLS_REAL_METHODS);

        assertThrows(UnimplementedException.class, dataContainer::asString);
    }

    @Test
    public void givenAsIntMethod_whenMockitoMock_throwsException() {
        Data dataContainer = Mockito.mock(Data.class, Mockito.CALLS_REAL_METHODS);

        assertThrows(UnimplementedException.class, dataContainer::asInt);
    }
}