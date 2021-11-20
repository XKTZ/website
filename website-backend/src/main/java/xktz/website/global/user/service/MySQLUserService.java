package xktz.website.global.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xktz.website.global.activation.service.ActivationCodeService;
import xktz.website.global.token.service.TokenService;
import xktz.website.global.user.User;
import xktz.website.global.user.dao.UserMapper;
import xktz.website.util.TokenUtil;

import java.util.List;

/**
 * A user service based on mysql
 */
@Service
public class MySQLUserService implements UserService {

    /**
     * The mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * Token service
     */
    @Autowired
    private TokenService tokenService;

    /**
     * Activate code service
     */
    @Autowired
    private ActivationCodeService activationCodeService;

    @Override
    public List<User> getUsers() {
        return userMapper.selectUsers();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public User getUserByToken(String token) {
        if (token.equals(TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE)) {
            return null;
        }
        return getUserById(tokenService.getToken(token).getUser());
    }

    @Override
    @Transactional
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    public User registerUser(String email, String username, String password) {
        var user = new User(null, username, password, email, false, false);
        this.addUser(user);
        activationCodeService.registerEmail(email, user.getId());
        return user;
    }

    @Override
    @Transactional
    public int updateUserById(User user) {
        return userMapper.updateByIdSelective(user);
    }

    @Override
    @Transactional
    public int activate(int userId) {
        var userTmp = new User(userId, null, null, null, null, true);
        updateUserById(userTmp);
        return userId;
    }

    @Override
    @Transactional
    public int deleteUserById(int id) {
        return userMapper.deleteById(id);
    }
}
