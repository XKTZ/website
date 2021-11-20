package xktz.website.global.token.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xktz.website.global.token.Token;
import xktz.website.global.token.dao.TokenMapper;
import xktz.website.global.user.User;
import xktz.website.global.user.service.UserService;
import xktz.website.util.TokenUtil;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.Date;

/**
 * Token service based on mysql
 */
@Service
@Slf4j
public class MySQLTokenService implements TokenService {

    private BigInteger indexOn = new BigInteger("0");

    private static final BigInteger STEP = new BigInteger("1");

    private static final String SPLITTER = "|";

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private UserService userService;

    private static final Date EXPIRING_DATE = new Date(Long.MIN_VALUE);

    @Override
    public boolean contains(String token) {
        return getToken(token) != null;
    }

    @Transactional
    @Override
    public Token getToken(String token) {
        return tokenMapper.selectByToken(token);
    }

    @Transactional
    @Override
    public int addToken(Token token) {
        return tokenMapper.insert(token);
    }

    /**
     * Create a token by user id
     *
     * @param user the user
     * @return the new token
     */
    @Transactional
    @Override
    public synchronized Token createToken(User user) {
        var tkn = newToken();
        var tknNew = new Token(tkn, new Time(System.currentTimeMillis() + TokenUtil.TOKEN_EXPIRE_TIME), user.getId());
        addToken(tknNew);
        log.info(String.format(TOKEN_CREATED_LOG, tknNew.getUser(), tknNew.getToken(), tknNew.getExpireDate()));
        return tknNew;
    }

    @Transactional
    @Override
    public int expireToken(int userId) {
        return tokenMapper.updateByUserSelective(new Token(null, EXPIRING_DATE, userId));
    }

    @Transactional
    @Override
    public int deleteToken(String token) {
        return tokenMapper.deleteByToken(token);
    }

    @Transactional
    @Override
    public int removeExpiredToken() {
        return tokenMapper.deleteExpired();
    }


    /**
     * Create a new token
     *
     * @return the token
     */
    private synchronized String newToken() {
        var timeOn = System.currentTimeMillis();
        return Base64.encodeBase64String(((indexOn = indexOn.add(STEP)) + SPLITTER + timeOn).getBytes(StandardCharsets.UTF_8));
    }

}
