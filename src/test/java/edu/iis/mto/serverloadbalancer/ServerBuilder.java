package edu.iis.mto.serverloadbalancer;

/**
 * Created by Sasho on 2017-06-16.
 */
public class ServerBuilder implements Builder<Server> {
    private int capacity;
    private double load;

    public ServerBuilder capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Server build() {
        Server server = new Server(capacity);
        if(this.load > 0){
            double size = (this.load * this.capacity)/100;
            server.addMachine(new VMachine(size));
        }
        return server;
    }

    public static ServerBuilder server() {
        return new ServerBuilder();
    }

    public Builder<Server> load(double v) {
        load = v;
        return this;
    }
}
