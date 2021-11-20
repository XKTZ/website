package xktz.website.web.login.domain;

import xktz.website.domain.OperationResult;
import xktz.website.global.user.User;

/**
 * A result for login
 */
public class LoginResult implements OperationResult {

    /**
     * Login success or not
     */
    private boolean success;

    /**
     * The message
     */
    private String message;

    /**
     * The token created
     */
    private String token;

    /**
     * The user
     */
    private User user;

    public LoginResult() {
    }

    public LoginResult(boolean success, String message, String token, User user) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.user = user;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
