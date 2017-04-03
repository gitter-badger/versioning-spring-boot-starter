package com.fintonic.versioning.context.error.accept;

import com.fintonic.versioning.annotation.VersionedResource;
import com.fintonic.versioning.context.WebContextConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rafael Ríos on 2/04/17.
 */

@SpringBootApplication
@Import(WebContextConfiguration.class)
public class SpringApplicationAcceptFailTest {

}

@RestController
@RequestMapping("/test")
class TestControllerFail {

    @RequestMapping
    @VersionedResource(to = "2.0")
    public String testVersion() {
        return "version-1.0-2.0";
    }



}