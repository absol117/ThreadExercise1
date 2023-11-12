package model;

public class SharedMonitorObj {

    private Object monitor = null;


    public SharedMonitorObj(Object monitor) {
        if (monitor == null) {
            throw new RuntimeException("L'oggetto Monitor non può essere null");
        }
        this.monitor = monitor;
    }

    public Object getMonitor() {
        return monitor;
    }
}
