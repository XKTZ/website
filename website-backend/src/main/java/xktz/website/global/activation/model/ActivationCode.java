package xktz.website.global.activation.model;

public class ActivationCode {
    private String key;

    private Integer user;

    public ActivationCode() {
    }

    public ActivationCode(String key, Integer user) {
        this.key = key;
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}