package xktz.website.web.login.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import xktz.website.web.login.domain.LoginResult;

/**
 * An aspect for login
 */
@Aspect
@Component
@Slf4j
public class LoginAspect {

    private static final String FORMAT_LOGIN_BY_TOKEN_SUCCESS = "Login with token success: %s";

    private static final String FORMAT_LOGIN_BY_TOKEN_FAIL = "Login with token fail: %s, message: %s";

    private static final String FORMAT_LOGIN_BY_EMAIL_SUCCESS = "Login with email success: {email: %s, pwd: %s}";

    private static final String FORMAT_LOGIN_BY_EMAIL_FAILED = "Login with email failed: {email: %s, pwd: %s}, message: %s";

    @Around("execution(xktz.website.web.login.domain.LoginResult xktz.website.web.login.LoginController.loginByToken(..))")
    public Object aroundLoginByToken(ProceedingJoinPoint joinPoint) throws Throwable {
        var args = joinPoint.getArgs();
        var res = (LoginResult) joinPoint.proceed();
        if (res.isSuccess()) {
            log.info(String.format(FORMAT_LOGIN_BY_TOKEN_SUCCESS, args[0]));
        } else {
            log.info(String.format(FORMAT_LOGIN_BY_TOKEN_FAIL, args[0], res.getMessage()));
        }
        res.setUser(res.getUser().excludePassword());
        return res;
    }

    @Around("execution(xktz.website.web.login.domain.LoginResult xktz.website.web.login.LoginController.loginByEmail(..))")
    public Object aroundLoginByUser(ProceedingJoinPoint joinPoint) throws Throwable {
        var args = joinPoint.getArgs();
        var res = (LoginResult) joinPoint.proceed();
        if (res.isSuccess()) {
            log.info(String.format(FORMAT_LOGIN_BY_EMAIL_SUCCESS, args[0], args[1]));
        } else {
            log.info(String.format(FORMAT_LOGIN_BY_EMAIL_FAILED, args[0], args[1], res.getMessage()));
        }
        res.setUser(res.getUser().excludePassword());
        return res;
    }
}

