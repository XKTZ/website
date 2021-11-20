package xktz.website.web.login.interceptor;

import org.springframework.stereotype.Component;
import xktz.website.domain.OperationResult;
import xktz.website.interceptor.TokenCookieInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginTokenCookieInterceptor extends TokenCookieInterceptor {

    @Override
    public String[] getPathPattern() {
        return new String[]{"/login/byToken"};
    }

    @Override
    protected boolean handleTourist(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response(response, OperationResult.getInstance(false, MESSAGE_LOGIN_FAILED_NO_TOKEN));
        return false;
    }


}
