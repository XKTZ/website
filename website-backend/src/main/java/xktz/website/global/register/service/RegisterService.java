package xktz.website.global.register.service;

import xktz.website.global.user.User;

/**
 * @author Yidi Chen
 * @date 2022-01-05
 */
public interface RegisterService {
    /**
     * Register a user
     *
     * @param email    the email
     * @param username the user name
     * @param password the password
     * @return the user
     */
    public User registerUser(String email, String username, String password);
}
