package org.example.ExceptionHandling;

public class InvalidPinException extends BankingException{
    public InvalidPinException(String msg){
        super(msg);
    }
}
