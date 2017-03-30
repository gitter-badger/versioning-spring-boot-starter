package com.fintonic.versioning.tests;

import com.fintonic.versioning.tests.context.error.accept.SpringApplicationAcceptFailTest;
import com.fintonic.versioning.tests.context.error.from.SpringApplicationFromFailTest;
import com.fintonic.versioning.tests.context.error.collision.SpringApplicationCollisionFailTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by rafa on 26/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FailTest {

    @Test(expected = Exception.class)
    public void testWhenVersionInSamePathCollision_ShouldReturnAException() throws Exception {

        AnnotationConfigEmbeddedWebApplicationContext context = new AnnotationConfigEmbeddedWebApplicationContext(SpringApplicationCollisionFailTest.class);
    }

    @Test(expected = Exception.class)
    public void testWhenVersionWithoutFrom_ShouldReturnAException() throws Exception {

        AnnotationConfigEmbeddedWebApplicationContext context = new AnnotationConfigEmbeddedWebApplicationContext(SpringApplicationFromFailTest.class);
    }

    @Test(expected = Exception.class)
    public void testWhenVersionWithoutAccept_ShouldReturnAException() throws Exception {

        AnnotationConfigEmbeddedWebApplicationContext context = new AnnotationConfigEmbeddedWebApplicationContext(SpringApplicationAcceptFailTest.class);
    }


}
