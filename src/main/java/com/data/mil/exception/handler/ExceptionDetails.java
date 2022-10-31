package com.data.mil.exception.handler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ExceptionDetails {

    private  final HttpStatus STATUS;
    private  final String MESSAGE;
    private  final int HTTP_CODE;

}