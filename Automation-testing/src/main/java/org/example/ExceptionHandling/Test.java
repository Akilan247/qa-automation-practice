package org.example.ExceptionHandling;

public class Test {
    public static void demo() {
        try {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                System.out.println("Inner catch");
//                throw e;
            }
        } catch (Exception e) {
            System.out.println("Outer catch");
        }
    }
    public static void main(String[] args) {
//        System.out.println(demo());
        demo();
    }
}