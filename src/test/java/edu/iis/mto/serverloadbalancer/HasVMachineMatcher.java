package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Sasho on 2017-06-17.
 */
public class HasVMachineMatcher extends TypeSafeMatcher<Server> {

    private VMachine vMachine;

    public HasVMachineMatcher(VMachine vMachine) {
        this.vMachine = vMachine;
    }

    public void describeTo(Description description) {
        description.appendText("Serwer powinien miec: ").appendValue(vMachine).appendText(" a nie mial");
    }

    protected boolean matchesSafely(Server server) {
        return server.containsVm(this.vMachine);
    }
    public static HasVMachineMatcher hasVMachine(VMachine vMachine) {
        return new HasVMachineMatcher(vMachine);
    }
}
