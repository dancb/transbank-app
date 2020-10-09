package com.authorization.api.controller.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiException {

    private HttpStatus status;
    private String message;

    public ApiException() {
    }

    public ApiException(HttpStatus httpStatus, String message) {
        this.status = httpStatus;
        this.message = message;
    }

}
