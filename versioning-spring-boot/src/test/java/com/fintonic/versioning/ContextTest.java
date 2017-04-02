package com.fintonic.versioning;

import com.fintonic.versioning.context.normal.SpringApplicationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by rafa on 26/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ContextTest {

    @Test
    public void test() throws Exception {

        AnnotationConfigEmbeddedWebApplicationContext context = new AnnotationConfigEmbeddedWebApplicationContext(SpringApplicationTest.class);
    }



}
