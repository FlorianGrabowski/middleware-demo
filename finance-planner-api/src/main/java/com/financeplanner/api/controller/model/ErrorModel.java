package com.financeplanner.api.controller.model;


import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;


@NoArgsConstructor
@Data
public class ErrorModel {
    private String timestamp;
    private int status;
    private String error;
    private String origin;
    private String message;
    private String path;

    public ErrorModel(HttpStatus httpStatus, HttpServletRequest originalRequest, Exception exception) {
        this.timestamp = new Timestamp(System.currentTimeMillis()).toString();
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.origin = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = originalRequest.getRequestURI();
    }
}
