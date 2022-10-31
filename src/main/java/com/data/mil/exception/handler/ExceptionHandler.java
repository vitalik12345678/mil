package com.data.mil.exception.handler;

import com.data.mil.exception.AlreadyExistsException;
import com.data.mil.exception.BadRequestException;
import com.data.mil.exception.MethodNotSupportedException;
import com.data.mil.exception.NotExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> handleNotFoundException(NotExistsException e){
        return buildExceptionBody(e, HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> handleAlreadyExistsException(AlreadyExistsException e){
        return buildExceptionBody(e, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        return buildExceptionBody(new BadRequestException(exception.getMessage()), status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        Map<String, String> mapMessage = new HashMap<>();
        mapMessage.put("startDate Invalid future date", "Дата не може бути у минулому");

        StringBuilder sb = new StringBuilder();
        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            if ( (error.getField() + " " + error.getDefaultMessage())
                    .contains("startDate Invalid future date") ) {
                sb.append(mapMessage.get("startDate Invalid future date")).append(" and ");
            } else {
                sb.append(error.getField()).append(" ").append(error.getDefaultMessage()).append(" and ");
            }
        });
        sb.setLength(sb.length() - 5);
        return buildExceptionBody(new BadRequestException(sb.toString()), status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException exception, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return buildExceptionBody(new MethodNotSupportedException(exception.getMessage()), status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        return buildExceptionBody(new BadRequestException(exception.getMessage()), status);
    }

    private ResponseEntity<Object> buildExceptionBody(Exception exception, HttpStatus httpStatus) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .MESSAGE(exception.getMessage())
                .STATUS(httpStatus)
                .HTTP_CODE(httpStatus.value())
                .build();
        return ResponseEntity
                .status(httpStatus)
                .body(exceptionDetails);
    }

}
