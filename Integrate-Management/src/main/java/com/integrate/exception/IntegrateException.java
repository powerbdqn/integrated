package com.integrate.exception;

public class IntegrateException extends Exception{

    
    //异常信息
    String message ;

    public IntegrateException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
