package xktz.website.web.login.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import xktz.website.interceptor.StandardHandlerInterceptor;
import xktz.website.interceptor.config.InterceptorConfigurer;

@Configuration
public class LoginConfigurer implements InterceptorConfigurer {

    @Autowired
    private LoginTokenCookieInterceptor loginTokenCookieInterceptor;

    @Override
    public StandardHandlerInterceptor[] getInterceptors() {
        return new StandardHandlerInterceptor[]{loginTokenCookieInterceptor};
    }
}
