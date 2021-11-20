package xktz.website.global.token;

import java.util.Date;

public class Token {
    private String token;

    private Date expireDate;

    private Integer user;

    public Token() {
    }

    public Token(String token, Date expireDate, Integer user) {
        this.token = token;
        this.expireDate = expireDate;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}