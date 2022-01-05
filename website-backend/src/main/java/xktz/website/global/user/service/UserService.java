package xktz.website.global.user.service;


import xktz.website.global.user.User;

import java.util.List;

/**
 * A service for users
 */
public interface UserService {

    /**
     * Get all of the users
     *
     * @return all of the users
     */
    List<User> getUsers();

    /**
     * Select user by id
     *
     * @param id the id
     * @return the user
     */
    public User getUserById(int id);

    /**
     * Select user by email
     *
     * @param email the email address
     * @return the email
     */
    public User getUserByEmail(String email);

    /**
     * Select user by token
     *
     * @param token the token
     * @return the user
     */
    public User getUserByToken(String token);

    /**
     * Add user into database
     *
     * @param user the user
     * @return the row influenced
     */
    public int addUser(User user);

    /**
     * Revise data in a user by id
     *
     * @param user the user
     * @return the row influenced
     */
    public int updateUserById(User user);

    /**
     * Delete the user by id
     *
     * @param id the id
     * @return the line influenced
     */
    int deleteUserById(int id);
}
