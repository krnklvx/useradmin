package org.example;

public class WrongLoginException extends Exception{
    public WrongLoginException(String s) {
        super(s);
    }
}
