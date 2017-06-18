package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Sasho on 2017-06-16.
 */
public class LoadPercentageMatcher extends TypeSafeMatcher<Server> {
    private double load;

    public LoadPercentageMatcher(double v) {
        load = v;
    }

    public void describeTo(Description description) {
        description.appendText("Oczekiwano obciazenia ").appendValue(load).appendText(" a przyszło inne");
    }

    protected boolean matchesSafely(Server server) {
        return this.load == server.getLoad();
    }

    public static LoadPercentageMatcher hasLoadPercentageOf(double v) {
        return new LoadPercentageMatcher(v);
    }
}
