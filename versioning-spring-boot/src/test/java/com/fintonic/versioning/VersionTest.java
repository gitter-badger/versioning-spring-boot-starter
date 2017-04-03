package com.fintonic.versioning;

import com.fintonic.versioning.domain.Version;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Rafael Ríos on 2/04/17.
 */
@RunWith(JUnit4.class)
public class VersionTest {

    @Test
    public void testEqual() {
        Version actual = new Version("1.0");
        Version other = new Version("1.0");

        assertThat(actual.compareTo(other), equalTo(0));
    }

    @Test
    public void testGreater() {
        Version actual = new Version("1.1");
        Version other = new Version("1.0");

        assertThat(actual.compareTo(other), equalTo(1));
    }

    @Test
    public void testLess() {
        Version actual = new Version("1.0");
        Version other = new Version("1.1");

        assertThat(actual.compareTo(other), equalTo(-1));
    }

    @Test(expected = Exception.class)
    public void testInvalidVersion() {
        Version actual = new Version("1.0.5");

    }


}
