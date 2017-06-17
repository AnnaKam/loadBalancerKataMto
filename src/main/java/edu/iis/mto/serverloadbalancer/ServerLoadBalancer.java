package edu.iis.mto.serverloadbalancer;

import java.util.List;

public class ServerLoadBalancer {
    public void balance(List<Server> servers, List<VMachine> vMachines) {
        for (VMachine vMachine: vMachines) {
            servers.get(0).addMachine(vMachine);
        }
    }
}
