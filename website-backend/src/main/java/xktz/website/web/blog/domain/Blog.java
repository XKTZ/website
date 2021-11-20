package xktz.website.web.blog.domain;


import java.util.ArrayList;
import java.util.List;

/**
 * A whole blog
 */
public class Blog {

    /**
     * The header of blog
     */
    private BlogHeader header;

    /**
     * The content of blog
     */
    private String content;

    /**
     * The comment of blog
     */
    private List<BlogComment> comments;

    public Blog(BlogHeader header, String content) {
        this.header = header;
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public Blog(BlogHeader header, String content, List<BlogComment> comment) {
        this.header = header;
        this.content = content;
        this.comments = comment;
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

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }
}
