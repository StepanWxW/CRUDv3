package repository;

import controller.ConnectMySQL;
import directory.RegionDirectory;
import model.Region;
import repository.implementation.RegionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegionRepositoryImp extends ConnectMySQL implements RegionRepository {

    @Override
    public Region create(Region region) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(RegionDirectory.REGION_CREATE)) {
            preparedStatement.setString(1, region.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem with create Region");
        }
        return region;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regionList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(RegionDirectory.REGION_GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getLong(1));
                region.setName(resultSet.getString(2));
                regionList.add(region);
            }
        } catch (SQLException e) {
            System.out.println("Problem with getAll Region");
        }
        return regionList;
    }

    @Override
    public Region getByID(Long id) {
        Region region = new Region();
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(RegionDirectory.REGION_GIT_ID);
        ) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            region.setId(id);
            while (resultSet.next()) {
                region.setName(resultSet.getString("REGION"));
            }
        } catch (SQLException e) {
            System.out.println("Problem with getId Region");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println("Problem whit close resultSet");;
            }
        }
        return region;
    }

    @Override
    public Region update(Region region) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(RegionDirectory.REGION_UPDATE);
        ) {
            preparedStatement.setString(1, region.getName());
            preparedStatement.setLong(2, region.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem with UpdateId Region");
        }
        return region;
    }

    @Override
    public void remove(Long id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(RegionDirectory.REGION_DELETE);
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem with Delete Region");
        }
    }
}
