package com.authorization.api.controller.avice;

import com.authorization.api.controller.exceptions.ApiException;
import com.authorization.api.controller.exceptions.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final String BAD_REQUEST_MESSAGE = "Parámetros invaídos, intente nuevamente";

    @ExceptionHandler({ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class,
            ForbiddenException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    protected ApiException handleForbiddenExceptions(Exception ex) {
        return new ApiException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
    }


}
