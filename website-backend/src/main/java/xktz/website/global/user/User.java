package xktz.website.global.user;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Boolean admin;

    private Boolean activated;

    public User() {
    }

    public User(Integer id, String username, String password, String email, Boolean admin, Boolean activated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
        this.activated = activated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }


    /**
     * Exclude the password
     *
     * @return the user excluding password
     */
    public User excludePassword() {
        return new User(id, username, null, email, admin, activated);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user.id.equals(id);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}