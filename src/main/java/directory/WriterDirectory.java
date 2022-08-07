package directory;

public class WriterDirectory {
    public static final String WRITER_CREATE = "INSERT INTO writer (Region) VALUES (?)";
    public static final String WRITER_GET_ALL = "SELECT * FROM region";
    public static final String WRITER_UPDATE = "UPDATE region SET Region = ? WHERE Id = ? ";
    public static final String WRITER_DELETE = "DELETE FROM region WHERE Id = ? ";
}
