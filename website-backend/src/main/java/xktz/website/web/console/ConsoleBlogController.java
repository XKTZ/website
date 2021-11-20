package xktz.website.web.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xktz.website.domain.OperationResult;
import xktz.website.global.user.service.UserService;
import xktz.website.web.blog.domain.Blog;
import xktz.website.web.blog.domain.BlogHeader;
import xktz.website.web.blog.service.BlogService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static xktz.website.util.TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE;
import static xktz.website.util.TokenUtil.TOKEN_COOKIE_NAME;

/**
 * The controller for blog function in console
 */
@RestController
@Slf4j
@RequestMapping("/console/blog")
public class ConsoleBlogController {
    private static final String MESSAGE_ADD_BLOG_SUCCESS = "ADD_BLOG_SUCCESS";
    private static final String MESSAGE_REMOVE_BLOG_SUCCESS = "REMOVE_BLOG_SUCCESS";

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<BlogHeader> listBlogs(@CookieValue(value = TOKEN_COOKIE_NAME,
            defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token) {
        return blogService.getBlogHeaders();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public OperationResult addBlog(@CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token,
                                   String title, String author, String summary, String type, Integer authority,
                                   String content) throws IOException {
        blogService.addBlog(new Blog(
                new BlogHeader(null, title, author, summary, new Date(), type, authority),
                content
        ));
        return OperationResult.getInstance(true, MESSAGE_ADD_BLOG_SUCCESS);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public OperationResult removeBlog(@CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token,
                                      @PathVariable("id") int id) throws IOException {
        blogService.deleteBlogById(id);
        return OperationResult.getInstance(true, MESSAGE_REMOVE_BLOG_SUCCESS);
    }

}
