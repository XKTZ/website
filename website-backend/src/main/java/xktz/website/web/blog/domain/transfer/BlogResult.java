package xktz.website.web.blog.domain.transfer;

import xktz.website.web.blog.domain.BlogHeader;

import java.util.List;

/**
 * A result of blog
 */
public class BlogResult {

    private BlogHeader header;

    private String content;

    private List<BlogCommentResult> comments;

    public BlogResult(BlogHeader header, String content, List<BlogCommentResult> comments) {
        this.header = header;
        this.content = content;
        this.comments = comments;
    }

    public BlogHeader getHeader() {
        return header;
    }

    public void setHeader(BlogHeader header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BlogCommentResult> getComments() {
        return comments;
    }

    public void setComments(List<BlogCommentResult> comments) {
        this.comments = comments;
    }

    static class BlogCommentResult {

        private String author;

        private String content;

        public BlogCommentResult(String author, String content) {
            this.author = author;
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }
    }



}