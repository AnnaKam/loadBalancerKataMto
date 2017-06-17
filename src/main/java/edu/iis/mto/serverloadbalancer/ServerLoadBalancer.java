package edu.iis.mto.serverloadbalancer;

import java.util.List;

public class ServerLoadBalancer {
    public void balance(List<Server> servers, List<VMachine> vMachines) {
        for (VMachine vMachine: vMachines) {
            findTheLeastLoaded(servers).addMachine(vMachine);
        }
    }
    private Server findTheLeastLoaded (List<Server> servers){
        Server chosenServer = null;
        for (Server server : servers) {
            if(chosenServer == null || chosenServer.getLoad() > server.getLoad()){
                chosenServer = server;
            }
        }
        return chosenServer;
    }
}
