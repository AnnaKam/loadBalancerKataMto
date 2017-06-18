package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasho on 2017-06-16.
 */
public class Server {
    private int capacity;
    private double load;

    public List<VMachine> getvMachines() {
        return vMachines;
    }

    private List<VMachine> vMachines = new ArrayList<VMachine>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public double getLoad() {
        return load;
    }

    public void addMachine(VMachine vMachine) {
        vMachines.add(vMachine);
        this.load = this.load + getVMachineLoad(vMachine);
    }

    public boolean containsVm(VMachine vMachine) {
        return vMachines.contains(vMachine);
    }

    public boolean hasEnoughSpace(VMachine vMachine) {
        return this.load + getVMachineLoad(vMachine) <= 100.0d;
    }

    private double getVMachineLoad (VMachine vMachine) {
        return (vMachine.getSize() / this.capacity) * 100.0d;
    }
}
