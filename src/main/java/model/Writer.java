package model;


import java.util.List;

public class Writer {
    private long id;
    private String firstName;
    private String lastName;
    private Region region;
    private List<Post> posts;


    public Writer(long id, String firstName, String lastName, List<Post> posts, Region region) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.posts = posts;
    }

    public Writer(String firstName, String lastName, List<Post> posts, Region region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.posts = posts;;
    }

    public Writer() {
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


    @Override
    public String toString() {
        return "\nWriter: " +
                "id=" + id +
                ",\n firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", region=" + region +
                ", posts=" + posts;
    }
}
