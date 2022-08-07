package directory;

public class RegionDirectory {
    public static final String REGION_CREATE = "INSERT INTO region (Region) VALUES (?)";
    public static final String REGION_GET_ALL = "SELECT * FROM region";
    public static final String REGION_UPDATE = "UPDATE region SET Region = ? WHERE Id = ? ";
    public static final String REGION_DELETE = "DELETE FROM region WHERE Id = ? ";

}
