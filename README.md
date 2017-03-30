# Spring boot starter Versioning

Spring boot starter using for versioning rest easily.

# Table of Contents
 
- [Overview](#overview)
- [Getting started](#getting-started)
- [License](#license)


### Overview

This implementation is based on the idea of this [StackOverflow](http://stackoverflow.com/questions/20198275/how-to-manage-rest-api-versioning-with-spring) thread.
For this approach we think that versioning with accept headers is the most RestFull option.
 

### Getting started


An example from the server side:

```java
import com.fintonic.microservice.starter.annotation.VersionedResource;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
    
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
```

An example from the client side:

```java
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", "application/vnd.app.resource-v1.0+json");
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/test", HttpMethod.GET, request, String.class);
    if(!response.getBody().equals("version-1.0-2.0") ){
        throw new RuntimeException("Error in version ");
    }

    headers = new HttpHeaders();
    headers.add("Accept", "application/vnd.app.resource-v3.0+json");
    request = new HttpEntity<>(headers);
    response = restTemplate.exchange("http://localhost:8080/test", HttpMethod.GET, request, String.class);
    if(!response.getBody().equals("version-3.0-4.0") ){
        throw new RuntimeException("Error in version ");
    }
```

#### How to use the latest release with Maven

Dependency:

```xml
<dependency>
    <groupId>com.fintonic</groupId>
    <artifactId>versioning-spring-boot-starter</artifactId>
    <version>0.5.0.RELEASE</version>
</dependency>

```

### License

Spring boot starter versioning is licensed under the MIT License. See [LICENSE](LICENSE.md) for details.

Copyright (c) 2017 Fintonic Servicios Financieros S.L.