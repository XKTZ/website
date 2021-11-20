package xktz.website.web.blog.domain.transfer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xktz.website.global.user.service.UserService;
import xktz.website.web.blog.domain.Blog;

import java.util.stream.Collectors;

/**
 * A util for transfering blogs
 */
@Component
public class BlogTransfer {

    @Autowired
    private UserService userService;

    public BlogResult transferable(Blog blog) {
        return new BlogResult(blog.getHeader(), blog.getContent(),
                blog.getComments().stream().map(blogComment -> new BlogResult.BlogCommentResult(
                        userService.getUserById(blogComment.getUser()).getUsername(),
                        blogComment.getContent()
                )).collect(Collectors.toList()));
    }
}
