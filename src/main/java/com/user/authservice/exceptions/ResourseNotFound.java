package com.user.authservice.exceptions;

public class ResourseNotFound extends RuntimeException{
    public ResourseNotFound(String msg){
        super(msg);
    }
}
