package edu.iis.mto.serverloadbalancer;

/**
 * Created by Sasho on 2017-06-17.
 */
public class VMachineBuilder {
    private double size;

    public VMachineBuilder size(int i) {
        this.size = i;
        return this;
    }

    public VMachine buid() {
        return new VMachine(size);
    }
}
