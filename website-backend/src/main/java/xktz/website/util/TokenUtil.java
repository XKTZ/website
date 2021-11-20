package xktz.website.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import xktz.website.global.token.Token;
import xktz.website.global.user.User;

import javax.servlet.http.Cookie;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Token util for adding tokens
 */
@Component
public class TokenUtil {

    public static final String TOKEN_COOKIE_NAME = "token";
    public static final String TOKEN_COOKIE_DEFAULT_VALUE = "fA==";
    public static final int TOKEN_EXPIRE_TIME = 7 * 24 * 60 * 60 ;
    public static final String TOKEN_COOKIE_PATH = "/";
    public static final int DEFAULT_COOKIE_EXPIRE_AGE = Integer.MAX_VALUE;

    @Autowired
    @Qualifier("loginTokenMap")
    private Map<String, User> tokenMap;

    @Autowired
    @Qualifier("loginUserMap")
    private Map<User, String> userMap;

    private BigInteger indexOn = new BigInteger("0");

    private static final BigInteger STEP = new BigInteger("1");

    private static final String SPLITTER = "|";

    /**
     * Add a new user into token set
     *
     * @param user the user
     * @return the token
     */
    public synchronized String addToken(User user) {
        if (userMap.containsKey(user)) {
            tokenMap.remove(userMap.get(user));
            userMap.remove(user);
        }
        var newToken = createToken();
        userMap.put(user, newToken);
        tokenMap.put(newToken, user);
        return newToken;
    }

    /**
     * Create a new token
     *
     * @return the token
     */
    private synchronized String createToken() {
        var timeOn = System.currentTimeMillis();
        return Base64.encodeBase64String(((indexOn = indexOn.add(STEP)) + SPLITTER + timeOn).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Get a token cookie
     * @return the token cookie
     */
    public synchronized Cookie getTokenCookie(Token token) {
        var cookie = new Cookie(TOKEN_COOKIE_NAME, token.getToken());
        cookie.setMaxAge(TOKEN_EXPIRE_TIME);
        cookie.setPath(TOKEN_COOKIE_PATH);
        return cookie;
    }
}
