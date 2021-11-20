package xktz.website.global.token.service;

import xktz.website.global.token.Token;
import xktz.website.global.user.User;

/**
 * Service for token
 */
public interface TokenService {

    String TOKEN_COOKIE_PATH = "/";
    String TOKEN_CREATED_LOG = "New token created: {user: %d, token: %s, expire date: %s}";


    /**
     * Get if contains the token or not
     *
     * @param token the token value
     * @return contains or not
     */
    public boolean contains(String token);

    /**
     * Get the token by token value
     *
     * @param token the token value
     * @return the token
     */
    public Token getToken(String token);

    /**
     * Insert a token
     *
     * @param token the token
     * @return the row influenced
     */
    public int addToken(Token token);

    /**
     * Create a token
     *
     * @param user the user
     * @return the token
     */
    public Token createToken(User user);

    /**
     * Expire all the token with user id
     *
     * @param userId the user id
     * @return expire
     */
    public int expireToken(int userId);

    /**
     * Delete the token
     *
     * @param token the token value
     * @return the row influenced
     */
    public int deleteToken(String token);

    /**
     * Remove all expired token
     *
     * @return the row influenced
     */
    public int removeExpiredToken();

}
