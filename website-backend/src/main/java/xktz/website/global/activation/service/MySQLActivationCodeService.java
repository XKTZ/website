package xktz.website.global.activation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xktz.website.global.activation.dao.ActivationCodeMapper;
import xktz.website.global.activation.model.ActivationCode;
import xktz.website.global.activation.model.ActivationCodeNotFoundException;
import xktz.website.global.activation.util.ActivationCodeUtil;
import xktz.website.global.user.User;
import xktz.website.global.user.service.UserService;

/**
 * The activation service for mysql
 */
@Service
public class MySQLActivationCodeService implements ActivationCodeService {

    @Autowired
    private ActivationCodeMapper activationCodeMapper;

    @Autowired
    private ActivationCodeUtil activationCodeUtil;

    @Autowired
    private UserService userService;

    @Override
    public boolean contains(String key) {
        return activationCodeMapper.selectByKey(key) != null;
    }

    @Override
    @Transactional
    public boolean addActivationCode(String code, int user) {
        int cnt = activationCodeMapper.insert(new ActivationCode(code, user));
        return cnt > 0;
    }

    @Override
    @Transactional
    public synchronized void activate(String code) {
        if (contains(code)) {
            var activeCode = activationCodeMapper.selectByKey(code);
            activateById(activeCode.getUser());
            activationCodeMapper.deleteByKey(activeCode.getKey());
        } else {
            throw new ActivationCodeNotFoundException(code);
        }
    }

    @Transactional
    public int activateById(int userId) {
        var userTmp = new User(userId, null, null, null, null, true);
        userService.updateUserById(userTmp);
        return userId;
    }

    @Override
    public void registerEmail(String email, int user) {
        String uuid;
        while (contains(uuid = activationCodeUtil.getUUID()));
        addActivationCode(uuid, user);
        activationCodeUtil.sendActivationCode(email, uuid);
    }
}
