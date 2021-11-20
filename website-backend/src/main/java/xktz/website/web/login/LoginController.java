package xktz.website.web.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xktz.website.domain.OperationResult;
import xktz.website.global.token.service.TokenService;
import xktz.website.global.user.service.UserService;
import xktz.website.util.TokenUtil;
import xktz.website.web.login.domain.LoginResult;

import javax.servlet.http.HttpServletResponse;

import static xktz.website.util.TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE;
import static xktz.website.util.TokenUtil.TOKEN_COOKIE_NAME;

/**
 * The controller for login
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    /**
     * The login service
     */
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * The message of login success
     */
    private static final String LOGIN_SUCCESS_MESSAGE = "LOGIN_SUCCESS";

    /**
     * The message cannot find token
     */
    private static final String LOGIN_FAILED_MESSAGE_CANNOT_FIND_TOKEN = "LOGIN_FAILED_CANNOT_FIND_TOKEN";

    /**
     * The message cannot find user
     */
    private static final String LOGIN_FAILED_MESSAGE_CANNOT_FIND_USER = "LOGIN_FAILED_CANNOT_FIND_USER";

    /**
     * The message password is not correct
     */
    private static final String LOGIN_FAILED_MESSAGE_PASSWORD_NOT_CORRECT = "LOGIN_FAILED_PASSWORD_NOT_CORRECT";

    /**
     * There is no token
     */
    private static final String NO_TOKEN = null;

    /**
     * Login by token
     * @param token the token
     */
    @RequestMapping(value = "/byToken", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult loginByToken(
            @CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token) {
        // if contains
        return new LoginResult(true, LOGIN_SUCCESS_MESSAGE, token, userService.getUserByToken(token).excludePassword());
    }

    /**
     * Login by email and password
     * @param email the email
     * @param password the password
     * @return the login result
     */
    @RequestMapping(value = "/byEmail", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult loginByEmail(String email, String password, HttpServletResponse response) {
        var user = userService.getUserByEmail(email);
        if (user == null) {
            return OperationResult.getInstance(false, LOGIN_FAILED_MESSAGE_CANNOT_FIND_USER);
        } else if (!user.getPassword().equals(password)) {
            return OperationResult.getInstance(false, LOGIN_FAILED_MESSAGE_PASSWORD_NOT_CORRECT);
        } else {
            var token = tokenService.createToken(user);
            var res = new LoginResult(true, LOGIN_SUCCESS_MESSAGE, token.getToken(), user);
            response.addCookie(tokenUtil.getTokenCookie(token));
            return res;
        }
    }
}
