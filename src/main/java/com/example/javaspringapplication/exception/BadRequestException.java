package com.example.javaspringapplication.exception;

public class BadRequestException extends Exception{
    public BadRequestException(String product_name_not_present) {
        super(product_name_not_present);
    }
}
