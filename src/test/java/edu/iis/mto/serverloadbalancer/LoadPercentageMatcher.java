package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Sasho on 2017-06-16.
 */
public class LoadPercentageMatcher extends TypeSafeMatcher {
    protected boolean matchesSafely(Object o) {
        return false;
    }

    public void describeTo(Description description) {

    }
}
