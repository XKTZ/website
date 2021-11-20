package xktz.website.web.blog.domain;

public class BlogComment {
    private Long id;

    private Integer user;

    private String content;

    private Integer blog;

    public BlogComment() {
    }

    public BlogComment(Long id, Integer user, String content, Integer blog) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.blog = blog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBlog() {
        return blog;
    }

    public void setBlog(Integer blog) {
        this.blog = blog;
    }
}