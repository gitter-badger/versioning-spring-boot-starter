package com.fintonic.versioning.tests.context.error.accept;

import com.fintonic.versioning.annotation.VersionedResource;
import com.fintonic.versioning.configuration.WebVersionAutoConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ImportAutoConfiguration(WebVersionAutoConfig.class)
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
