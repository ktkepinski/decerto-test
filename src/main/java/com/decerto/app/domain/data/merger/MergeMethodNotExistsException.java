package com.decerto.app.domain.data.merger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Merge method not found")
public class MergeMethodNotExistsException extends RuntimeException {
}
