package com.supermart.exception;

public class InvalidEmailException extends Exception{
   public InvalidEmailException(String errorMsg){
        super(errorMsg);
    }
}
