package xktz.website.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import xktz.website.global.token.service.TokenService;
import xktz.website.global.user.User;
import xktz.website.global.user.service.UserService;
import xktz.website.util.JsonUtil;
import xktz.website.util.TokenUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class TokenCookieInterceptor implements StandardHandlerInterceptor {

    protected static final Cookie DEFAULT_COOKIE =
            new Cookie(TokenUtil.TOKEN_COOKIE_NAME, TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE);

    protected static final String MESSAGE_LOGIN_FAILED_NO_TOKEN = "FAILED_NO_TOKEN";

    protected static final String MESSAGE_FAILED_NOT_ADMIN = "FAIL_NOT_ADMIN";

    @Autowired
    protected TokenService tokenService;

    @Autowired
    protected UserService userService;

    static {
        DEFAULT_COOKIE.setMaxAge(TokenUtil.DEFAULT_COOKIE_EXPIRE_AGE);
        DEFAULT_COOKIE.setPath("/");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var tokenCookie = findTokenCookie(request, response);
        if (tokenCookie.getValue().equals(TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE)) {
            return handleTourist(request, response, handler);
        } else {
            var user = userService.getUserByToken(tokenCookie.getValue());
            return handleUser(request, response, handler, user);
        }
    }


    protected boolean handleTourist(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return StandardHandlerInterceptor.super.preHandle(request, response, handler);
    }

    protected boolean handleUser(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 User user) throws Exception {
        return StandardHandlerInterceptor.super.preHandle(request, response, handler);
    }

    protected Cookie findTokenCookie(HttpServletRequest request, HttpServletResponse response) {
        var cookies = request.getCookies();
        if (cookies == null) {
            response.addCookie(DEFAULT_COOKIE);
            return DEFAULT_COOKIE;
        }
        for (var cookie : cookies) {
            if (cookie.getName().equals(TokenUtil.TOKEN_COOKIE_NAME)) {
                var token = cookie.getValue();
                if (!tokenService.contains(token)) {
                    response.addCookie(DEFAULT_COOKIE);
                    return DEFAULT_COOKIE;
                }
                return cookie;
            }
        }
        response.addCookie(DEFAULT_COOKIE);
        return DEFAULT_COOKIE;
    }

    protected <T> void response(HttpServletResponse response, T obj) throws IOException {
        try (var writer = response.getWriter()) {
            writer.write(JsonUtil.toString(obj));
        }
    }
}
