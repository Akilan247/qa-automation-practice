package org.example.ExceptionHandling;

public class InsufficientBalanceException extends BankingException{

    public InsufficientBalanceException(){}

    public InsufficientBalanceException(String msg){
        super(msg);
    }

}
