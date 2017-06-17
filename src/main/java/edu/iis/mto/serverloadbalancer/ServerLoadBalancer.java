package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class ServerLoadBalancer {
    public void balance(List<Server> servers, List<VMachine> vMachines) {
        for (VMachine vMachine: vMachines) {
            List<Server> properServers = new ArrayList<Server>();
            for (Server server : servers) {
                if(server.hasEnoughSpace(vMachine)){
                    properServers.add(server);
                }
            }
            Server chosenServer = findTheLeastLoaded(properServers);
            if(chosenServer != null){
                chosenServer.addMachine(vMachine);
            }
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
