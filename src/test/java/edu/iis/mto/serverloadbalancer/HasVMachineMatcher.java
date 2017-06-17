package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Sasho on 2017-06-17.
 */
public class HasVMachineMatcher extends TypeSafeMatcher<Server> {

    public void describeTo(Description description) {

    }

    protected boolean matchesSafely(Server server) {
        return false;
    }
}
