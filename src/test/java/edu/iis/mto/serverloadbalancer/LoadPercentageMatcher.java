package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Sasho on 2017-06-16.
 */
public class LoadPercentageMatcher extends TypeSafeMatcher<Server> {
    private double obciazenie;

    public LoadPercentageMatcher(double v) {
        obciazenie = v;
    }

    public void describeTo(Description description) {

    }

    protected boolean matchesSafely(Server server) {
        if(this.obciazenie == server.obciazenie){
            return true;
        } else {
            return false;
        }
    }
}
