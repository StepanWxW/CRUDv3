package directory;

public class PostDirectory {
    public static final String POST_CREATE = "INSERT INTO post (content, createTime, updateTime, postStatus) VALUES (?, ?, ?, ?)";
    public static final String POST_GET_ALL = "SELECT * FROM post";
    public static final String POST_UPDATE = "UPDATE post SET content = ?, updateTime = ?, postStatus = ? WHERE Id = ? ";
    public static final String POST_DELETE = "DELETE FROM post WHERE Id = ? ";
}
