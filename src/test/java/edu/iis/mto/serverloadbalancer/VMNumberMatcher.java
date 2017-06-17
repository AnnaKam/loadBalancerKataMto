package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class VMNumberMatcher extends TypeSafeMatcher<Server> {
    private int number;

    public VMNumberMatcher(int number) {
        this.number = number;
    }

    protected boolean matchesSafely(Server server) {
        return this.number == server.getvMachines().size();
    }

    public void describeTo(Description description) {
        description.appendText("Serwer powinien miec ").appendValue(this.number).appendText(" maszyny, a nie ma");
    }

    public static VMNumberMatcher hasMachineCountOf(int number) {
        return new VMNumberMatcher(number);
    }
}
