package com.decerto.app.application.data.source.integer;

import com.decerto.app.application.data.source.DataSource;
import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
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
        DataSource dataSource = new RandomOrgDataSource(restTemplate, 1, 1, 100);

        Data result = dataSource.getData();

        assertNotNull(result);
        assertEquals(result.getClass(), IntegerData.class);
        assertEquals(10, result.asInt());
    }
}