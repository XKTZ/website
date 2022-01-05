package xktz.website.global.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xktz.website.global.activation.service.ActivationCodeService;
import xktz.website.global.user.User;
import xktz.website.global.user.service.UserService;

/**
 * @author Yidi Chen
 * @date 2022-01-05
 */
@Service
public class MySQLRegisterService implements RegisterService {

    @Autowired
    private ActivationCodeService activationCodeService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public User registerUser(String email, String username, String password) {
        var user = new User(null, username, password, email, false, false);
        userService.addUser(user);
        activationCodeService.registerEmail(email, user.getId());
        return user;
    }
}
