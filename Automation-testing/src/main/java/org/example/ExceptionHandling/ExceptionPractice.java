package org.example.ExceptionHandling;
import java.util.Scanner;

public class ExceptionPractice {
    public static void main(String[] args) throws InputNotMatchedException{
        Scanner s = new Scanner(System.in);
        int pin;
            try {
                System.out.println("Enter your ATM Pin :");
                pin = s.nextInt();
                pinValidation(pin);
            }
            catch (Exception e) {
                System.out.println("Invalid input format.....");
            }
    }
    public static void pinValidation(int pin){
        try {
            if(!findPinLength(pin)) throw new InvalidPinLengthException("Wrong Pin");
            else withdraw();
        }catch (InvalidPinLengthException e){
            System.out.println(e);
        }
    }

    public static void withdraw(){
        System.out.println("Enter amount:");
        int amount = new Scanner(System.in).nextInt();

        try {
            if(amount<500) throw new InsufficientBalanceException("Insufficient Balance, Please Check your Balance!");
            else System.out.println("Transaction Successfully..");
        }catch (InsufficientBalanceException e){
            System.out.println(e);
        }
    }

    public static boolean findPinLength(int pin){
        return Integer.valueOf(pin).toString().length()==4;
    }
}
