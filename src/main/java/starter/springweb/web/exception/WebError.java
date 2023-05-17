package starter.springweb.web.exception;

import lombok.AllArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2022/06/29
 * Copyright (C) 2022, Centum Factorial all rights reserved.
 */

@AllArgsConstructor
enum WebError {
    INVALID_REQUEST_BODY_FIELD_VALUE_FORMAT("유효하지 않은 Request Body 입니다. [%s: %s]"),
    INVALID_REQUEST_PARAM_FIELD_VALUE_FORMAT("유효하지 않은 Request Param 입니다. [%s: %s]"),
    INVALID_REQUEST_HEADER_FORMAT("유효하지 않은 Request Header 입니다. [%s: %s]"),
    TYPE_MISMATCH("RequestParam 혹은 PathVariable 에서 Field Type 바인딩에 실패하였습니다."),
    INVALID_FORM_FILED_VALUE("유효하지 않은 Form 입니다."),
    INVALID_REQUEST_BODY_FIELD_VALUE("유효하지 않은 Request Body 입니다."),
    HTTP_METHOD_NOT_SUPPORTED_FORMAT("지원하지 않는 Http Method 입니다: %s"),
    INVALID_MULTIPART_FILE_FORMAT("유효하지 않은 Multipart file 입니다: [%s : %s]"),
    ;

    private final String message;

    public String getMessage() {
        return this.message;
    }
}
