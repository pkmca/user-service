package com.example.userservice.exception;

public class DuplicateDataException extends RuntimeException{

    public DuplicateDataException(String msg){
        super(msg);
    }
}
