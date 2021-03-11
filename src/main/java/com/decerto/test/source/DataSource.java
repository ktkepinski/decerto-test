package com.decerto.test.source;

import com.decerto.test.data.Data;

public interface DataSource<T> {
    Data<T> getData();
}
