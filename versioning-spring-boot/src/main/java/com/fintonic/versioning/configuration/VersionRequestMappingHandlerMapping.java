package com.fintonic.versioning.configuration;

import com.fintonic.versioning.annotation.VersionedResource;
import com.fintonic.versioning.domain.PathVersionMap;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * Custom RequestMappingHandlerMapping.
 *
 * Created by Rafa on 24/01/17.
 */
public class VersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        VersionedResource versionResourceAnnotation = AnnotationUtils.findAnnotation(handlerType, VersionedResource.class);

        if (versionResourceAnnotation != null) {
            if (StringUtils.isEmpty(versionResourceAnnotation.media())) {
                throw new IllegalArgumentException("Media cannot be null in class annotation");
            }
            return createCondition(versionResourceAnnotation.media(), versionResourceAnnotation.from(), versionResourceAnnotation.to(), "");
        }
        return null;
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        VersionedResource methodAnnotation = AnnotationUtils.findAnnotation(method, VersionedResource.class);
        if (methodAnnotation != null && StringUtils.isEmpty(methodAnnotation.from())) {
            throw new IllegalArgumentException("From must be declared in method");
        }
        RequestMapping requestMappingClass = AnnotationUtils.findAnnotation(method.getDeclaringClass(), RequestMapping.class);
        String classPath = requestMappingClass == null ? "" : String.join("/", requestMappingClass.path());

        RequestMapping requestMappingMethod = AnnotationUtils.findAnnotation(method, RequestMapping.class);
        String path = requestMappingMethod == null ? classPath : classPath.concat(String.join("/", requestMappingMethod.path()));


        if (methodAnnotation != null) {
            VersionedResource classAnnotation = AnnotationUtils.findAnnotation(method.getDeclaringClass(), VersionedResource.class);
            if (classAnnotation == null && StringUtils.isEmpty(methodAnnotation.media())) {
                throw new IllegalArgumentException("Media must be declared");
            }

            PathVersionMap.INSTANCE.checkColisionPathWithVersion(path, methodAnnotation.from(), methodAnnotation.to());

            return createCondition(methodAnnotation.media(), methodAnnotation.from(), methodAnnotation.to(), path);
        } else {
            return null;
        }

    }

    private RequestCondition<?> createCondition(String media, String from, String to, String path) {

        return new VersionRequestCondition(media, from, to, path);

    }
}
