package xktz.website.web.register;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xktz.website.domain.OperationResult;

/**
 * Controller for activation
 */
@RestController
@RequestMapping("/activate")
public class ActivationController {
    
    @RequestMapping(value = "/{code}", method = RequestMethod.POST)
    public OperationResult activate(@PathVariable("code") String code) {
        return null;
    }
}
