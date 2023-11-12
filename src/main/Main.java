package main;

import model.ExcengerValue;
import model.SharedMonitorObj;

public class Main {
    public static void main(String[] args) {

        ExcengerValue excengerValue = new ExcengerValue();
        SharedMonitorObj sharedMonitorObj1 = new SharedMonitorObj(excengerValue);
        SharedMonitorObj sharedMonitorObj2 = new SharedMonitorObj(excengerValue);


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(sharedMonitorObj1.getMonitor() instanceof ExcengerValue) {
                    ((ExcengerValue) sharedMonitorObj1.getMonitor()).incrementa();
                    System.out.println("Incremento da SharedMon 1 : " + ((ExcengerValue) sharedMonitorObj1.getMonitor()).getCounter());
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(sharedMonitorObj2.getMonitor() instanceof ExcengerValue) {
                    ((ExcengerValue) sharedMonitorObj2.getMonitor()).incrementa();
                    System.out.println("Incremento da SharedMon 2 : " + ((ExcengerValue) sharedMonitorObj2.getMonitor()).getCounter());
                }
            }
        });

        ExcengerValue excengerValue2 = new ExcengerValue();
        SharedMonitorObj sharedMonitorObj3 = new SharedMonitorObj(excengerValue2);
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(sharedMonitorObj3.getMonitor() instanceof ExcengerValue) {
                    ((ExcengerValue) sharedMonitorObj3.getMonitor()).incrementa();
                    System.out.println("Incremento da SharedMon 3 : " + ((ExcengerValue) sharedMonitorObj3.getMonitor()).getCounter());
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
