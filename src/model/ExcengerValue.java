package model;

public class ExcengerValue {
    private int counter = 0;

    public void incrementa() {
        synchronized (this) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
