package xktz.website.web.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xktz.website.global.user.service.UserService;
import xktz.website.web.blog.domain.BlogHeader;
import xktz.website.web.blog.domain.transfer.BlogCommentOperationResult;
import xktz.website.web.blog.domain.transfer.BlogResult;
import xktz.website.web.blog.domain.transfer.BlogTransfer;
import xktz.website.web.blog.service.BlogService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static xktz.website.util.TokenUtil.TOKEN_COOKIE_DEFAULT_VALUE;
import static xktz.website.util.TokenUtil.TOKEN_COOKIE_NAME;

/**
 * The controller for blogs
 */
@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogTransfer blogTransfer;

    private static final String MESSAGE_ADD_COMMENT_SUCCESS = "ADD_COMMENT_SUCCESS";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<BlogHeader> listBlogs(@CookieValue(value = TOKEN_COOKIE_NAME,
            defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token) {
        var user = userService.getUserByToken(token);
        boolean admin = user != null && user.isAdmin();
        return blogService.getBlogHeaders().stream().filter(x ->
                x.getAuthority() == 0 || admin).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BlogResult getBlogById(@CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token,
                                  @PathVariable("id") int id) throws IOException {
        var user = userService.getUserByToken(token);
        var blg = blogService.getBlogById(id);
        return blogTransfer.transferable(blg);
    }

    @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
    public BlogCommentOperationResult addComment(
            @CookieValue(value = TOKEN_COOKIE_NAME, defaultValue = TOKEN_COOKIE_DEFAULT_VALUE) String token,
            @PathVariable("id") int blogId, String content) {
        int userId = userService.getUserByToken(token).getId();
        blogService.addComment(userId, content, blogId);
        return new BlogCommentOperationResult(true, MESSAGE_ADD_COMMENT_SUCCESS);
    }
}
