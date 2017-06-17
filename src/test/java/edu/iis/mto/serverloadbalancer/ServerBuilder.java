package edu.iis.mto.serverloadbalancer;

/**
 * Created by Sasho on 2017-06-16.
 */
public class ServerBuilder implements Builder<Server> {
    private int capacity;

    public ServerBuilder capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Server build() {
        return new Server(capacity);
    }

    public static ServerBuilder server() {
        return new ServerBuilder();
    }

    public Builder<Server> load(double v) {
        return null;
    }
}
