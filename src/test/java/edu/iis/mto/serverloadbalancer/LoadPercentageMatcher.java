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
        description.appendText("Oczekiwano obciazenia ").appendValue(obciazenie).appendText(" a przyszło inne");
    }

    protected boolean matchesSafely(Server server) {
        if(this.obciazenie == server.getLoad()){
            return true;
        } else {
            return false;
        }
    }

    public static LoadPercentageMatcher hasLoadPercentageOf(double v) {
        return new LoadPercentageMatcher(v);
    }
}
