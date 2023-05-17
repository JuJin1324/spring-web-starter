package starter.springweb.web.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/17
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestControllerExceptionHandler {
    /**
     * 지원하지 않은 Http Method 및 URI 로 요청한 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleHttpRequestMethodNotSupportedException(HttpServletRequest request,
                                                                         HttpRequestMethodNotSupportedException e) {
        log.error("[Handle HttpRequestMethodNotSupportedException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }

    /**
     * 애노테이션 @Valid 를 사용하여 데이터를 검증할 때 해당 데이터에 에러가 있는 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMethodArgumentNotValidException(HttpServletRequest request,
                                                                  MethodArgumentNotValidException e) {
        log.error("[Handle MethodArgumentNotValidException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }

    /**
     * 애노테이션 @Valid 를 사용하여 데이터를 검증할 때 해당 데이터에 에러가 있는 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMethodArgumentNotValidException(HttpServletRequest request,
                                                                  ConstraintViolationException e) {
        log.error("[Handle MethodArgumentNotValidException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }

    /**
     * 애노테이션 @ModelAttribute 으로 binding error 발생시 BindException 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleBindException(HttpServletRequest request,
                                                BindException e) {
        log.error("[Handle BindException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }

    /**
     * Query string 으로 온 값이 @RequestParam 의 데이터에 binding 되지 못했을 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMethodArgumentTypeMismatchException(HttpServletRequest request,
                                                                      MethodArgumentTypeMismatchException e) {
        log.error("[Handle MethodArgumentTypeMismatchException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }

    /**
     * Query string 에 @RequestParam(required = true) 값이 누락된 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMissingServletRequestParameterException(HttpServletRequest request,
                                                                          MissingServletRequestParameterException e) {
        log.error("[Handle MissingServletRequestParameterException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }

    /**
     * HTTP Header 에 @RequestHeader(required = true) 의 값이 누락된 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMissingRequestHeaderException(HttpServletRequest request,
                                                                MissingRequestHeaderException e) {
        log.error("[Handle handleMissingRequestHeaderException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI());
        return ErrorResponse.from(e);
    }

    /**
     * Request body 로 온 JSON 문자열이 없거나, JSON 포멧이 아니거나 혹은 @RequestBody 애노테이션을 단 자료형으로 파싱 실패한 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleHttpMessageNotReadableException(HttpServletRequest request,
                                                                  HttpMessageNotReadableException e) {
        log.error("[Handle HttpMessageNotReadableException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }

    /**
     * Form 에 @RequestPart(required = true) 의 값이 누락된 경우 발생.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMissingServletRequestPartException(HttpServletRequest request,
                                                                     MissingServletRequestPartException e) {
        log.error("[Handle MissingServletRequestPartException] requestURI: {} {}",
                request.getMethod(), request.getRequestURI(), e);
        return ErrorResponse.from(e);
    }
}
