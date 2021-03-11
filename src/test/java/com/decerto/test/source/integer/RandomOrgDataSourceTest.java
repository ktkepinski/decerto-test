package com.decerto.test.source.integer;

import com.decerto.test.data.Data;
import com.decerto.test.data.integer.IntegerData;
import com.decerto.test.source.DataSource;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RandomOrgDataSourceTest {

    @Test
    void getData_ShouldReturnValidData() {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class, (invocation) -> ResponseEntity.ok("10"));
        when(restTemplate.exchange(any(), any(), any(), ArgumentMatchers.eq(String.class))).thenReturn(ResponseEntity.ok("10"));
        DataSource<Integer> dataSource = new RandomOrgDataSource(restTemplate, 1, 100);

        Data<Integer> result = dataSource.getData();

        assertNotNull(result);
        assertEquals(result.getClass(), IntegerData.class);
        assertEquals(10, result.getData());
    }
}