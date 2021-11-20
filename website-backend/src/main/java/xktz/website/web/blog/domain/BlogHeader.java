package xktz.website.web.blog.domain;

import java.util.Date;

public class BlogHeader {
    private Integer id;

    private String title;

    private String author;

    private String summary;

    private Date createdDate;

    private String type;

    private Integer authority;

    public BlogHeader() {
    }

    public BlogHeader(Integer id, String title, String author, String summary, Date createdDate, String type, Integer authority) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.createdDate = createdDate;
        this.type = type;
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}