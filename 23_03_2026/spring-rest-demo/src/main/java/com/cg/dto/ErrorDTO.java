package com.cg.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ErrorDTO {
    private String errorMessage;
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate now;
    private String uri;

    public ErrorDTO() {}

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDate getNow() {
        return now;
    }

    public void setNow(LocalDate now) {
        this.now = now;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ErrorDTO(String errorMessage, LocalDate now, String uri) {
        this.errorMessage = errorMessage;
        this.now = now;
        this.uri = uri;
    }
}
