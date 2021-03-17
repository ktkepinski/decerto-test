package com.decerto.app.application.data.source;

import com.decerto.app.domain.data.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public abstract class RestApiDataSource implements DataSource {

    private final RestTemplate restTemplate;

    @Override
    public Data getData() {
        return wrap(restTemplate.exchange(getResourceUrl(), getHttpMethod(), getRequest(), String.class));
    }

    protected abstract HttpEntity<?> getRequest();

    protected abstract HttpMethod getHttpMethod();

    protected abstract Data wrap(ResponseEntity<String> entity);

    protected abstract String getResourceUrl();
}
