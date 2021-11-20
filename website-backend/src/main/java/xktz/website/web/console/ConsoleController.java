package xktz.website.web.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xktz.website.global.user.service.UserService;
import xktz.website.util.TokenUtil;
import xktz.website.web.blog.service.BlogService;

/**
 * The console (can only be loged in by admin)
 */
@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @ResponseBody
    public boolean adminLoggedIn(@CookieValue(value = "token", defaultValue = TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE)
                              String token) {
        var usr = userService.getUserByToken(token);
        return usr != null && usr.isAdmin();
    }

}
