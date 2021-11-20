package xktz.website.web.blog.interceptor;


import org.springframework.stereotype.Component;
import xktz.website.domain.OperationResult;
import xktz.website.interceptor.TokenCookieInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The blog token cookie interceptor
 */
@Component
public class BlogTokenCookieInterceptor extends TokenCookieInterceptor {

    @Override
    public String[] getPathPattern() {
        return new String[]{"/blog/**/comment"};
    }

    @Override
    protected boolean handleTourist(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response(response, OperationResult.getInstance(false, MESSAGE_LOGIN_FAILED_NO_TOKEN));
        return false;
    }
}
