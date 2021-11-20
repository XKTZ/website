package xktz.website.web.console.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import xktz.website.interceptor.StandardHandlerInterceptor;
import xktz.website.interceptor.config.InterceptorConfigurer;

@Configuration
public class ConsoleConfigurer implements InterceptorConfigurer {

    @Autowired
    private ConsoleTokenCookieInterceptor consoleTokenCookieInterceptor;

    @Override
    public StandardHandlerInterceptor[] getInterceptors() {
        return new StandardHandlerInterceptor[]{consoleTokenCookieInterceptor};
    }
}
