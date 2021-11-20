package xktz.website.web.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xktz.website.web.project.domain.Project;
import xktz.website.web.project.service.ProjectService;

import java.util.List;

import static xktz.website.util.TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE;
import static xktz.website.util.TokenUtil.TOKEN_COOKIE_NAME;

@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Project> list(@CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token) {
        return projectService.list();
    }
}
