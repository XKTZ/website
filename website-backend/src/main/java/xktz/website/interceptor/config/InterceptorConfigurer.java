package xktz.website.interceptor.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xktz.website.interceptor.StandardHandlerInterceptor;

public interface InterceptorConfigurer extends WebMvcConfigurer {

    StandardHandlerInterceptor[] getInterceptors();

    @Override
    default void addInterceptors(InterceptorRegistry registry) {
        addRegistry(registry);
    }

    default void addRegistry(InterceptorRegistry registry) {
        var interceptors = getInterceptors();
        for (var interceptor: interceptors) {
            registry.addInterceptor(interceptor)
                    .addPathPatterns(interceptor.getPathPattern())
                    .excludePathPatterns(interceptor.getExcludePattern());
        }
    }
}
