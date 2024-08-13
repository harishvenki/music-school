package com.music.school.response;

public class ErrorResponseDTO {
    private String errorMessage;
    private int errorCode;

    // Constructors
    public ErrorResponseDTO() {}

    public ErrorResponseDTO(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    // Getters and Setters
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
