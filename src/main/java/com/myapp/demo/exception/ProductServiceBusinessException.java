package com.myapp.demo.exception;

public class ProductServiceBusinessException extends RuntimeException {
    public ProductServiceBusinessException(String message){
        super(message);
    }
}
