package com.muslimov.vlad.metricsconsumer.exception.handler;

import com.muslimov.vlad.metricsconsumer.exception.model.MetricNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(MetricNotFoundException.class)
    public ResponseEntity<String> notFoundException(MetricNotFoundException exception) {

        log.error(exception.getMessage(), exception);

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
    }
}