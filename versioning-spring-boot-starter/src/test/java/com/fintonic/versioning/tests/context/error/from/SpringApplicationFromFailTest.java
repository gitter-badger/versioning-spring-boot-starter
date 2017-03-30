package com.fintonic.versioning.tests.context.error.from;

import com.fintonic.versioning.annotation.VersionedResource;
import com.fintonic.versioning.configuration.WebVersionAutoConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ImportAutoConfiguration(WebVersionAutoConfig.class)
public class SpringApplicationFromFailTest {

}

@RestController
@RequestMapping("/test")
@VersionedResource(media = "application/vnd.app.resource")
class TestControllerFail {

    @RequestMapping
    @VersionedResource(to = "2.0")
    public String testVersion() {
        return "version-1.0-2.0";
    }



}
