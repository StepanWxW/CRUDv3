package model;


import java.util.List;

public class Writer {
    private long id;
    private String firstName;
    private String lastName;
    private Region region;
    private List<Post> posts;
    private Role role;

    public Writer(long id, String firstName, String lastName, List<Post> posts, Region region, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.posts = posts;
        this.role = role;
    }

    public Writer(String firstName, String lastName, List<Post> posts, Region region, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.posts = posts;
        this.role = role;
    }

    public Writer(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", region=" + region +
                ", posts=" + posts +
                ", role=" + role +
                '}';
    }
}