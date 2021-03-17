package com.decerto.app.application.data.source.integer;

import com.decerto.app.application.data.source.RestApiDataSource;
import com.decerto.app.domain.data.Data;
import com.decerto.app.domain.data.integer.IntegerData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class RandomOrgDataSource extends RestApiDataSource {
    private static String URL = "https://www.random.org/integers/?num=1&min=%d&max=%d&col=1&base=10&format=plain&rnd=new";

    private final int min;
    private final int max;
    private final long id;

    public RandomOrgDataSource(RestTemplate restTemplate, long id, int min, int max) {
        super(restTemplate);
        this.id = id;
        this.min = min;
        this.max = max;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return "RandomOrgIntegerGenerator";
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
    protected Data wrap(ResponseEntity<String> entity) {
        return new IntegerData(Integer.parseInt(entity.getBody().trim()));
    }

    @Override
    protected String getResourceUrl() {
        return String.format(URL, min, max);
    }

}
