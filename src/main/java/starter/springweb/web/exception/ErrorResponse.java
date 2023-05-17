package starter.springweb.web.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2021/06/01
 * Copyright (C) 2021, Centum Factorial all rights reserved.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
class ErrorResponse {
    @JsonIgnore
    private static final String MESSAGE_INTERNAL_SERVER_ERROR = "서버 내부 오류가 발생하였습니다.";

    private final long timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final List<FieldError> fieldErrors;

    private ErrorResponse(HttpStatus status, String message,
                          @Nullable List<FieldError> fieldErrors) {

        this.timestamp = LocalDateTime.now(ZoneId.of("UTC"))
                .toInstant(ZoneOffset.UTC).toEpochMilli();
        this.status = status.value();
        this.error = status.name();
        this.message = message;
        this.fieldErrors = fieldErrors;
    }

    public static ErrorResponse from(MethodArgumentNotValidException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                WebError.INVALID_REQUEST_BODY_FIELD_VALUE.getMessage(),
                FieldError.of(e.getBindingResult())
        );
    }

    public static ErrorResponse from(BindException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                WebError.INVALID_FORM_FILED_VALUE.getMessage(),
                FieldError.of(e.getBindingResult())
        );
    }

    public static ErrorResponse from(MethodArgumentTypeMismatchException e) {
        final String value = e.getValue() == null ? "" : String.valueOf(e.getValue());
        final List<FieldError> errors = FieldError.of(e.getName(), value, e.getErrorCode());

        return new ErrorResponse(HttpStatus.BAD_REQUEST, WebError.TYPE_MISMATCH.getMessage(), errors);
    }

    public static ErrorResponse from(MissingServletRequestParameterException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                String.format(WebError.INVALID_REQUEST_PARAM_FIELD_VALUE_FORMAT.getMessage(), e.getParameterName(), "null"),
                null);
    }

    public static ErrorResponse from(MissingServletRequestPartException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                String.format(WebError.INVALID_MULTIPART_FILE_FORMAT.getMessage(), e.getRequestPartName(), "null"),
                null);
    }

    public static ErrorResponse from(MissingRequestHeaderException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                String.format(WebError.INVALID_REQUEST_HEADER_FORMAT.getMessage(), e.getHeaderName(), "null"),
                null);
    }

    public static ErrorResponse from(HttpMessageNotReadableException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                String.format(WebError.INVALID_REQUEST_BODY_FIELD_VALUE.getMessage(), "requestBody", e.getHttpInputMessage()),
                null);
    }

    public static ErrorResponse from(HttpRequestMethodNotSupportedException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                String.format(WebError.HTTP_METHOD_NOT_SUPPORTED_FORMAT.getMessage(), e.getMethod()),
                null);
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static List<FieldError> of(final String field, final String value, @Nullable final String reason) {
            List<FieldError> fieldErrors = new ArrayList<>();
            fieldErrors.add(new FieldError(field, value, reason));
            return fieldErrors;
        }

        private static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}
