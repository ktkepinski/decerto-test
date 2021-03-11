package com.decerto.test.source;

import com.decerto.test.data.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public abstract class RestApiDataSource<T> implements DataSource<T> {

    private final RestTemplate restTemplate;

    @Override
    public Data<T> getData() {
        return wrap(restTemplate.exchange(getResourceUrl(), getHttpMethod(), getRequest(), String.class));
    }

    protected abstract HttpEntity<?> getRequest();

    protected abstract HttpMethod getHttpMethod();

    protected abstract Data<T> wrap(ResponseEntity<String> entity);

    protected abstract String getResourceUrl();

    protected abstract Class<?> getType();
}
