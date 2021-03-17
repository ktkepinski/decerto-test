package com.decerto.app.application.data;

import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
import com.decerto.app.domain.data.merger.DataMerger;
import com.decerto.app.domain.data.merger.MergeMethodNotExistsException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DataMergeServiceTest {

    @Test
    void merge_givenDataAndMethodId_shouldUseDataMergerToMergeData() {
        DataMerger dataMerger = Mockito.mock(DataMerger.class);
        given(dataMerger.getId()).willReturn(1L);
        List<Data> dataList = Arrays.asList(new IntegerData(5));
        DataMergeService dataMergeService = new DataMergeService(Arrays.asList(dataMerger));
        dataMergeService.merge(dataList, 1L);

       verify(dataMerger, times(1)).merge(dataList);
    }

    @Test
    void merge_givenNonExistingMethodId_shouldThrowMergeMethodNotExistsException() {
        assertThrows(MergeMethodNotExistsException.class,
                () -> new DataMergeService(Collections.emptyList()).merge(Collections.emptyList(), 1L));
    }
}