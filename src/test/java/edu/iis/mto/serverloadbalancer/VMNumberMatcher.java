package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class VMNumberMatcher extends TypeSafeMatcher<Server> {
    protected boolean matchesSafely(Server server) {
        return false;
    }

    public void describeTo(Description description) {

    }
}
