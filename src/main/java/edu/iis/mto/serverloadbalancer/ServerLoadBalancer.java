package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class ServerLoadBalancer {
    public void balance(List<Server> servers, List<VMachine> vMachines) {
        for (VMachine vMachine: vMachines) {
            Server chosenServer = findTheLeastLoaded(findServersOfProperSize(servers, vMachine));
            if(chosenServer != null){
                chosenServer.addMachine(vMachine);
            }
        }
    }

    private List<Server> findServersOfProperSize (List<Server> servers, VMachine vMachine){
        List<Server> properServers = new ArrayList<Server>();
        for (Server server : servers) {
            if(server.hasEnoughSpace(vMachine)){
                properServers.add(server);
            }
        }
        return properServers;
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
