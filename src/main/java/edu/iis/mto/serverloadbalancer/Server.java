package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasho on 2017-06-16.
 */
public class Server {
    private int capacity;
    private double obciazenie;

    public List<VMachine> getvMachines() {
        return vMachines;
    }

    private List<VMachine> vMachines = new ArrayList<VMachine>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public double getLoad() {
        return obciazenie;
    }

    public void addMachine(VMachine vMachine) {
        vMachines.add(vMachine);
        this.obciazenie = this.obciazenie + ((vMachine.getSize() / this.capacity) * 100.0d);
    }

    public boolean containsVm(VMachine vMachine) {
        return vMachines.contains(vMachine);
    }

    public boolean hasEnoughSpace(VMachine vMachine) {
        return this.obciazenie + ((vMachine.getSize() / this.capacity) * 100.0d) <= 100.0d;
    }
}
