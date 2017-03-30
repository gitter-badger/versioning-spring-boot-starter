package com.fintonic.versioning.tests.context.error.collision;

import com.fintonic.versioning.annotation.VersionedResource;
import com.fintonic.versioning.configuration.WebVersionAutoConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ImportAutoConfiguration(WebVersionAutoConfig.class)
public class SpringApplicationCollisionFailTest {

}

@RestController
@RequestMapping("/test")
@VersionedResource(media = "application/vnd.app.resource")
class TestControllerFail {

    @RequestMapping
    @VersionedResource(from = "1.0", to = "2.0")
    public String testVersion1And2() {
        return "version-1.0-2.0";
    }

    @RequestMapping
    @VersionedResource(from = "2.0")
    public String testVersion3And4() {
        return "version-3.0-4.0";
    }




}
