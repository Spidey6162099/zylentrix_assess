package com.example.zylentrix_assessment.Exceptions;

public class UserCreationException extends RuntimeException{
    public UserCreationException(String message){
        super(message);
    }
    public UserCreationException(String message,Throwable th){
        super(message,th);
    }
}
