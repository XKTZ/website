package xktz.website.web.console.domain;

import xktz.website.domain.OperationResult;
import xktz.website.global.user.User;

import java.util.List;

/**
 * An operation result for user
 */
public class UserOperationResult implements OperationResult {

    private boolean success;
    private String message;

    private List<User> users;

    public UserOperationResult(boolean success, String message, List<User> users) {
        this.success = success;
        this.message = message;
        this.users = users;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
