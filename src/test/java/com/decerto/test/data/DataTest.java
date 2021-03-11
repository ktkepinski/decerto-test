package com.decerto.test.data;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DataTest {

    @Test
    public void givenAddingIdentityMethod_whenMockitoMock_throwsException() {
        Data<Object> data = Mockito.mock(Data.class, Mockito.CALLS_REAL_METHODS);

        assertThrows(UnimplementedException.class, data::addingIdentity);
    }

    @Test
    public void givenAddingMethod_whenMockitoMock_throwsException() {
        Data<Object> data = Mockito.mock(Data.class, Mockito.CALLS_REAL_METHODS);

        assertThrows(UnimplementedException.class, data::addingIdentity);
    }
}