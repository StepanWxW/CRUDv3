package controller.repository.implementation;

import controller.repository.PostRepository;
import directory.PostDirectory;
import model.Post;
import model.PostStatus;
import util.ConnectMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl extends ConnectMySQL implements PostRepository {
    @Override
    public Post create(Post post) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PostDirectory.POST_CREATE)) {
            preparedStatement.setString(1, post.getContent());
            preparedStatement.setTimestamp(2, getTimeStamp());
            preparedStatement.setTimestamp(3, getTimeStamp());
            preparedStatement.setString(4, String.valueOf(post.getPostStatus()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem with create Post");
        }
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> postsList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PostDirectory.POST_GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getLong(1));
                post.setContent(resultSet.getString(2));
                post.setCreate(resultSet.getTimestamp(3));
                post.setUpdate(resultSet.getTimestamp(4));
                post.setPostStatus(PostStatus.valueOf(resultSet.getString(5)));
                postsList.add(post);
            }
        } catch (SQLException e) {
            System.out.println("Problem with getAll Post");
        }
        return postsList;
    }

    @Override
    public Post getById(Long id) {
        return getAll().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Post update(Post post) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PostDirectory.POST_UPDATE);
        ) {
            preparedStatement.setString(1, post.getContent());
            preparedStatement.setTimestamp(2, getTimeStamp());
            preparedStatement.setString(3, String.valueOf(post.getPostStatus()));
            preparedStatement.setLong(4, post.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem with UpdateId Post");
        }
        return post;
    }

    @Override
    public void remove(Long id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PostDirectory.POST_DELETE);
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem with Delete Post");
        }
    }

    private Timestamp getTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
