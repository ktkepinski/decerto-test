package com.decerto.test.source.integer;

import com.decerto.test.data.Data;
import com.decerto.test.data.integer.IntegerData;
import com.decerto.test.source.RestApiDataSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class RandomOrgDataSource extends RestApiDataSource<Integer> {
    private final int min;
    private final int max;

    public RandomOrgDataSource(RestTemplate restTemplate, int min, int max) {
        super(restTemplate);
        this.min = min;
        this.max = max;
    }

    @Override
    protected HttpEntity<?> getRequest() {
        HttpHeaders headers = getHeaders();
        return new HttpEntity<>(headers);
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));
        return headers;
    }

    @Override
    protected Data<Integer> wrap(ResponseEntity<String> entity) {
        return new IntegerData(Integer.valueOf(entity.getBody().trim()));
    }

    @Override
    protected String getResourceUrl() {
        return String.format("https://www.random.org/integers/?num=1&min=%d&max=%d&col=1&base=10&format=plain&rnd=new", min, max);
    }

    @Override
    protected Class<?> getType() {
        return Integer.class;
    }
}
