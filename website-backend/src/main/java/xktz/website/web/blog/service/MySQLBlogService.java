package xktz.website.web.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xktz.website.web.blog.dao.BlogCommentMapper;
import xktz.website.web.blog.dao.BlogHeaderMapper;
import xktz.website.web.blog.domain.Blog;
import xktz.website.web.blog.domain.BlogComment;
import xktz.website.web.blog.domain.BlogHeader;
import xktz.website.web.blog.util.BlogIO;

import java.io.IOException;
import java.util.List;

/**
 * Mysql blog service
 */
@Service
@Slf4j
public class MySQLBlogService implements BlogService {

    @Autowired
    private BlogHeaderMapper blogHeaderMapper;

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Autowired
    private BlogIO blogIO;

    @Override
    public List<BlogHeader> getBlogHeaders() {
        return blogHeaderMapper.selectAll();
    }

    @Override
    public BlogHeader getBlogHeaderById(int id) {
        return blogHeaderMapper.selectById(id);
    }

    @Override
    public Blog getBlogById(int id) throws IOException {
        var header = blogHeaderMapper.selectById(id);
        var comments = blogCommentMapper.selectByBlog(id);
        String content;
        content = blogIO.getBlogContent(id);
        return new Blog(header, content, comments);
    }

    @Transactional
    @Override
    public int addBlog(Blog blog) throws IOException {
        int res = blogHeaderMapper.insert(blog.getHeader());
        blogIO.updateBlogContent(blog.getHeader().getId(), blog.getContent());
        for (var comment : blog.getComments()) {
            blogCommentMapper.insert(comment);
            res++;
        }
        return res;
    }

    @Transactional
    @Override
    public int updateBlogHeader(BlogHeader header) throws IOException {
        return blogHeaderMapper.updateById(header);
    }

    @Transactional
    @Override
    public void updateBlogContent(int id, String content) throws IOException {
        blogIO.updateBlogContent(id, content);
    }

    @Transactional
    @Override
    public int deleteBlogById(int id) throws IOException {
        int cnt = 0;
        cnt += blogHeaderMapper.deleteById(id);
        cnt += blogCommentMapper.deleteByBlogId(id);
        blogIO.removeBlogContent(id);
        return cnt;
    }

    @Transactional
    @Override
    public int deleteCommentById(Long id) {
        return blogCommentMapper.deleteById(id);
    }

    @Transactional
    @Override
    public BlogComment addComment(int author, String content, int blog) {
        BlogComment comment = new BlogComment(null, author, content, blog);
        blogCommentMapper.insert(comment);
        return comment;
    }
}
