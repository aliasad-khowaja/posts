package com.webservice.posts.exception;

import java.util.Date;

public class ExceptionResponse {

    private Date timestanmp;
    private String message;
    private String detail;

    public ExceptionResponse(Date timestanmp, String message, String detail) {
        this.timestanmp = timestanmp;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestanmp() {
        return timestanmp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
