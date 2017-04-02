package com.fintonic.versioning;

import com.fintonic.versioning.domain.VersionRange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Rafael Ríos on 2/04/17.
 */
@RunWith(JUnit4.class)
public class VersionRangeTest {

    @Test(expected = Exception.class)
    public void testEmptyFromVersion_ShouldReturnException() {
        new VersionRange(null, "1.0");
    }

    @Test(expected = Exception.class)
    public void testFromLessThanTo_ShouldReturnException() {
        new VersionRange("2.0", "1.0");

    }

}
