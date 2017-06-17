package edu.iis.mto.serverloadbalancer;

/**
 * Created by Sasho on 2017-06-16.
 */
public class VMachine {
    public double getSize() {
        return size;
    }

    private double size;

    public VMachine(double size) {
        this.size = size;
    }
}
