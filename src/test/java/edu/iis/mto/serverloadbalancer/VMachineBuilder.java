package edu.iis.mto.serverloadbalancer;

/**
 * Created by Sasho on 2017-06-17.
 */
public class VMachineBuilder implements Builder<VMachine>{
    private double size;

    public VMachineBuilder size(int i) {
        this.size = i;
        return this;
    }
    public VMachine build() {
        return new VMachine(size);
    }

    public static VMachineBuilder vMachnine() {
        return new VMachineBuilder();
    }
}
