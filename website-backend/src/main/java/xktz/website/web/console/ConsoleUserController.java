package xktz.website.web.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xktz.website.global.user.User;
import xktz.website.global.user.service.UserService;
import xktz.website.util.JsonUtil;
import xktz.website.web.blog.service.BlogService;
import xktz.website.web.console.domain.UserOperationResult;

import java.util.List;

import static xktz.website.util.RequestUtil.CODE_UPDATE_MAP;

@RestController
@RequestMapping("/console/user")
public class ConsoleUserController {

    private static final String MESSAGE_ADD_USER_SUCCESS = "ADD_USER_SUCCESS";
    private static final String MESSAGE_UPDATE_USER_SUCCESS = "UPDATE_USER_SUCCESS";
    private static final String MESSAGE_REMOVE_USER_SUCCESS = "REMOVE_USER_SUCCESS";
    private static final String MESSAGE_REMOVE_USER_FAILED = "REMOVE_USER_FAILED";

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> listUsers(@CookieValue("token") String token) {
        return userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User listUsers(@CookieValue("token") String token, @PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserOperationResult addUser(@CookieValue("token") String token,
                                       String name, String password, String email, boolean admin, boolean activated) {
        var user = new User(null, name, password, email, admin, activated);
        userService.addUser(user);
        return new UserOperationResult(true, MESSAGE_ADD_USER_SUCCESS, userService.getUsers());
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public UserOperationResult updateUser(@CookieValue("token") String token,
                                          Integer id, String name, String password, String email,
                                          @RequestParam("admin") Integer adminCode,
                                          @RequestParam("activated") Integer activatedCode) {
        var user = new User(id, name, password, email,
                CODE_UPDATE_MAP.get(adminCode), CODE_UPDATE_MAP.get(activatedCode));
        userService.updateUserById(user);
        return new UserOperationResult(true, MESSAGE_UPDATE_USER_SUCCESS, userService.getUsers());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserOperationResult removeUser(@CookieValue("token") String token, @PathVariable("id") Integer id) {
        int cnt = userService.deleteUserById(id);
        if (cnt >= 1) {
            return new UserOperationResult(true, MESSAGE_REMOVE_USER_SUCCESS, userService.getUsers());
        } else {
            return new UserOperationResult(true, MESSAGE_REMOVE_USER_FAILED, userService.getUsers());
        }
    }
}
