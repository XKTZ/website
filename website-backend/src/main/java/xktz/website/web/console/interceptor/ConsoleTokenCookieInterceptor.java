package xktz.website.web.console.interceptor;

import org.springframework.stereotype.Component;
import xktz.website.domain.OperationResult;
import xktz.website.global.user.User;
import xktz.website.interceptor.TokenCookieInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Console's token cookie interceptor
 */
@Component
public class ConsoleTokenCookieInterceptor extends TokenCookieInterceptor {

    @Override
    protected boolean handleTourist(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response(response, OperationResult.getInstance(false, MESSAGE_LOGIN_FAILED_NO_TOKEN));
        return false;
    }

    @Override
    protected boolean handleUser(HttpServletRequest request, HttpServletResponse response, Object handler, User user) throws Exception {
        if (!user.isAdmin()) {
            response(response, OperationResult.getInstance(false, MESSAGE_FAILED_NOT_ADMIN));
            return false;
        }
        return super.handleUser(request, response, handler, user);
    }

    @Override
    public String[] getPathPattern() {
        return new String[]{"/console/**"};
    }

    @Override
    public String[] getExcludePattern() {
        return new String[]{"/console/admin/"};
    }
}
