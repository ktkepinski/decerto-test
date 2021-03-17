package com.decerto.app.application.data.source;

import com.decerto.app.domain.data.Data;

public interface DataSource {
    Data getData();
    Long getId();
    String getName();
}
