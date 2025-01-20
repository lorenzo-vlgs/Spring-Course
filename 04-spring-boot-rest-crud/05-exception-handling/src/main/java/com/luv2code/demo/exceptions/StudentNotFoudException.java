package com.luv2code.demo.exceptions;

public class StudentNotFoudException extends RuntimeException{

    public StudentNotFoudException(String message){ super(message); }

    public StudentNotFoudException(String message, Throwable cause){ super(message,cause); }

    public StudentNotFoudException(Throwable cause){ super(cause); }
}
