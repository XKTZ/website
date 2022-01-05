package xktz.website.web.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xktz.website.domain.OperationResult;
import xktz.website.global.activation.service.ActivationCodeService;
import xktz.website.global.register.service.RegisterService;
import xktz.website.global.user.User;
import xktz.website.global.user.service.UserService;

/**
 * Controller for register the user
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private ActivationCodeService activationCodeService;

    private static final String MESSAGE_REGISTER_SUCCESS = "REGISTER_SUCCESS";
    private static final String MESSAGE_ACTIVATE_SUCCESS = "ACTIVATE_SUCCESS";

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public OperationResult register(String email, String username, String password) {
        var user = new User(null, username, password, email, false, false);
        registerService.registerUser(email, username, password);
        return OperationResult.getInstance(true, MESSAGE_REGISTER_SUCCESS);
    }

    @RequestMapping(value = "/activate/{code}")
    public OperationResult activate(@PathVariable String code) {
        activationCodeService.activate(code);
        return OperationResult.getInstance(true, MESSAGE_ACTIVATE_SUCCESS);
    }
}
