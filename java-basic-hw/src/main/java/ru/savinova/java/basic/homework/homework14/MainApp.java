package ru.savinova.java.basic.homework.homework14;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        double[] array = new double[100000000];
        oneStream(array);
        fourStream(array);
    }

    public static void oneStream(double[] array) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    public static void fourStream(double[] array) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25000000; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 25000000; i < 50000000; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 50000000; i < 75000000; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 75000000; i < 100000000; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        long time1 = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}