package com.decerto.app.application.data;

import com.decerto.app.application.data.source.DataSource;
import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DataProviderTest {

    @Mock
    private DataSource dataSourceOne;
    @Mock
    private DataSource dataSourceTwo;

    @BeforeEach
    public void setup() {
        given(dataSourceOne.getId()).willReturn(1L);
        given(dataSourceOne.getName()).willReturn("source1");
        given(dataSourceOne.getData()).willReturn(new IntegerData(5));
        given(dataSourceTwo.getId()).willReturn(2L);
    }

    @Test
    void getData_givenSourceIdList_shouldReturnDataOnlyFromDataSourcesMatchingId() {
        DataProvider dataProvider = new DataProvider(Arrays.asList(dataSourceOne, dataSourceTwo));

        List<Data> result = dataProvider.getData(Arrays.asList(1L, 3L));

        assertEquals(1, result.size());
        assertEquals(new IntegerData(5), result.get(0));
    }
}