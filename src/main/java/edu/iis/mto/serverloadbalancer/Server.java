package edu.iis.mto.serverloadbalancer;

/**
 * Created by Sasho on 2017-06-16.
 */
public class Server {
    private int capacity;
    private double obciazenie;

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public double getLoad() {
        return obciazenie;
    }
}
