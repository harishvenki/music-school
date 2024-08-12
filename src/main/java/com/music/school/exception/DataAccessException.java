package com.music.school.exception;


public class DataAccessException extends RuntimeException {
    public DataAccessException(String errorMessage) {
        super(errorMessage);
    }

    public DataAccessException(Throwable err) {
        super(err);
    }
    public DataAccessException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
