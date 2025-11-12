package org.example.ExceptionHandling;

public class InputNotMatchedException extends Throwable{

    public InputNotMatchedException(){super();}
    public InputNotMatchedException(String message){
        super(message);
    }


    public static void main(String[] args) {try {
                throw new RuntimeException("Try");
            } catch (Exception e) {
                throw new RuntimeException("Catch");
            } finally {
                throw new RuntimeException("Finally");
            }
    }
}
