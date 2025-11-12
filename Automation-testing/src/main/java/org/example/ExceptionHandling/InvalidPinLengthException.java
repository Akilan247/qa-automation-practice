package org.example.ExceptionHandling;

public class InvalidPinLengthException extends BankingException{

    public InvalidPinLengthException(String message){
        super(message);
    }
}
