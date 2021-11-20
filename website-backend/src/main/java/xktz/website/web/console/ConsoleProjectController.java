package xktz.website.web.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xktz.website.domain.OperationResult;
import xktz.website.web.project.domain.Project;
import xktz.website.web.project.service.ProjectService;

import java.util.List;

import static xktz.website.util.TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE;
import static xktz.website.util.TokenUtil.TOKEN_COOKIE_NAME;

@RestController
@RequestMapping("/console/project")
public class ConsoleProjectController {

    private static final String MESSAGE_REMOVE_SUCCESS = "REMOVE_SUCCESS";
    private static final String MESSAGE_REMOVE_FAIL = "REMOVE_FAIL";
    private static final String MESSAGE_ADD_SUCCESS = "ADD_SUCCESS";
    private static final String MESSAGE_ADD_FAIL = "ADD_FAIL";

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Project> list(@CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token) {
        return projectService.list();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public OperationResult addProject(@CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token,
                                      String name, String desc, String url) {
        int cnt = projectService.insert(name, desc, url);
        if (cnt > 0) {
            return OperationResult.getInstance(true, MESSAGE_ADD_SUCCESS);
        } else {
            return OperationResult.getInstance(false, MESSAGE_ADD_FAIL);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public OperationResult removeProject(@CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token,
                                         @PathVariable("id") Integer id) {
        int cnt = projectService.delete(id);
        if (cnt > 0) {
            return OperationResult.getInstance(true, MESSAGE_REMOVE_SUCCESS);
        } else {
            return OperationResult.getInstance(false, MESSAGE_REMOVE_FAIL);
        }
    }
}
