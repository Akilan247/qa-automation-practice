package org.example.ExceptionHandling;

public class BankingException extends Throwable{
    public BankingException(){}
    public BankingException(String msg){
        super(msg);
    }
}
