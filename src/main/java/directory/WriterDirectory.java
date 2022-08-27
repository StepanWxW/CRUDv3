package directory;

public class WriterDirectory {
    public static final String WRITER_CREATE = "INSERT INTO writer (Id, firstName, lastName, idRegion) VALUES (?, ?, ?, ?)";
    public static final String WRITER_POST_CREATE = "INSERT INTO writerpost (idWriter, idPost) VALUES (?, ?)";
    public static final String WRITER_GET_ALL = "SELECT * FROM writer";
    public static final String WRITER_POST_GET_ALL = "SELECT * FROM writerpost";
    public static final String WRITER_POST_ALL_DELETE = "DELETE FROM writerpost WHERE idWriter = ? ";
    public static final String WRITER_UPDATE = "UPDATE writer SET firstName = ?, lastName = ?, idRegion = ? WHERE Id = ?";
    public static final String WRITER_DELETE = "DELETE FROM writer WHERE Id = ? ";

}
