package xktz.website.web.blog.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import xktz.website.interceptor.StandardHandlerInterceptor;
import xktz.website.interceptor.config.InterceptorConfigurer;

@Configuration
public class BlogConfigurer implements InterceptorConfigurer {

    @Autowired
    private BlogTokenCookieInterceptor blogTokenCookieInterceptor;

    @Override
    public StandardHandlerInterceptor[] getInterceptors() {
        return new StandardHandlerInterceptor[]{blogTokenCookieInterceptor};
    }
}
