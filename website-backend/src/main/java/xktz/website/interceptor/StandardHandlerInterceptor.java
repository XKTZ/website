package xktz.website.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

public interface StandardHandlerInterceptor extends HandlerInterceptor {


    String[] getPathPattern();

    default String[] getExcludePattern() {return new String[]{};}
}
