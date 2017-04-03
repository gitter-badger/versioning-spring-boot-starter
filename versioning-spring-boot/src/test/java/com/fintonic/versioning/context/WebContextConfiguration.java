package com.fintonic.versioning.context;

import com.fintonic.versioning.configuration.VersionRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
public class WebContextConfiguration extends WebMvcConfigurationSupport {
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        VersionRequestMappingHandlerMapping handlerMapping = new VersionRequestMappingHandlerMapping();
        handlerMapping.setOrder(1);
        return handlerMapping;
    }
}
