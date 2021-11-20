package xktz.website.web.project.domain;

public class Project {
    private Integer id;

    private String name;

    private String desc;

    private String url;

    public Project() {
    }

    public Project(String name, String desc, String url) {
        this.name = name;
        this.desc = desc;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}