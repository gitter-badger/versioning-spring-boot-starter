package com.fintonic.versioning.context.normal;

import com.fintonic.versioning.annotation.VersionedResource;
import com.fintonic.versioning.context.WebContextConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Import(WebContextConfiguration.class)
public class SpringApplicationTest {

}

@RestController
@RequestMapping("/test")
@VersionedResource(media = "application/vnd.app.resource")
class TestController {

    @RequestMapping
    @VersionedResource(from = "1.0", to = "2.0")
    public String testVersion1And2() {
        return "version-1.0-2.0";
    }

    @RequestMapping
    @VersionedResource(from = "3.0", to = "4.0")
    public String testVersion3And4() {
        return "version-3.0-4.0";
    }


    @RequestMapping
    @VersionedResource(from = "6.0")
    public String testVersion6ToInfinite() {
        return "version-6-Infinite";
    }


}
