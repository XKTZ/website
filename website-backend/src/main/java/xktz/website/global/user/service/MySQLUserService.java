package xktz.website.global.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public int updateUserById(User user) {
        return userMapper.updateByIdSelective(user);
    }

    @Override
    @Transactional
    public int deleteUserById(int id) {
        return userMapper.deleteById(id);
    }
}
