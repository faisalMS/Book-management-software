package com.example.bookmanagementsoftware.Exception;

public class BooksNotFoundException extends RuntimeException{
    public BooksNotFoundException(String message){
        super(message);
    }
}
