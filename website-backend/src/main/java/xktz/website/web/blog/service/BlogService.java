package xktz.website.web.blog.service;

import xktz.website.web.blog.domain.Blog;
import xktz.website.web.blog.domain.BlogComment;
import xktz.website.web.blog.domain.BlogHeader;

import java.io.IOException;
import java.util.List;

/**
 * The blog service
 */
public interface BlogService {

    /**
     * Select all the blogs
     *
     * @return all the blogs
     */
    public List<BlogHeader> getBlogHeaders();

    /**
     * Get the blog by id
     *
     * @param id the id
     * @return the blog
     */
    public BlogHeader getBlogHeaderById(int id);

    /**
     * Get a blog by id
     *
     * @param id the id
     * @return the blog
     */
    public Blog getBlogById(int id) throws IOException;

    /**
     * Insert a blog
     *
     * @param blog the blog
     * @return the row influenced
     */
    public int addBlog(Blog blog) throws IOException;

    /**
     * Update blog header
     *
     * @param header the header
     * @return the row influenced
     * @throws IOException
     */
    public int updateBlogHeader(BlogHeader header) throws IOException;

    /**
     * Update a blog
     *
     * @param id      the id
     * @param content the content
     */
    public void updateBlogContent(int id, String content) throws IOException;

    /**
     * Delete a blog
     *
     * @param id the id
     * @return the row influenced
     */
    public int deleteBlogById(int id) throws IOException;

    /**
     * Remove the comment by id
     *
     * @param id the comment id
     * @return the row influenced
     */
    public int deleteCommentById(Long id);

    /**
     * Add a comment by providing author, content, and blog
     *
     * @param author  the author
     * @param content the content
     * @param blog    the blog
     * @return the row influenced
     */
    public BlogComment addComment(int author, String content, int blog);
}
