package org.example.Keywords;

public class VolatileDemo {
    public static int count;
    public static volatile boolean flag;
    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->{
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag = true;
        });
        Thread thread2 = new Thread(() -> {
            while(!flag){

            }
            System.out.println("Flag is now true..");
        });
        thread1.start();
        thread2.start();
    }
}
