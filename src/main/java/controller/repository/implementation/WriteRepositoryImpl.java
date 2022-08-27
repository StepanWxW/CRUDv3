package controller.repository.implementation;

import directory.WriterDirectory;
import model.Post;
import model.Writer;
import controller.repository.WriterRepository;
import util.ConnectMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WriteRepositoryImpl extends ConnectMySQL implements WriterRepository {
    @Override
    public Writer create(Writer writer) {
        try (Connection connection = getConnection();
             PreparedStatement prepStatWriter = connection.prepareStatement(WriterDirectory.WRITER_CREATE);
             PreparedStatement prepStatWriterPost = connection.prepareStatement(WriterDirectory.WRITER_POST_CREATE)) {
            long id = generateId();
            prepStatWriter.setLong(1, id);
            prepStatWriter.setString(2, writer.getFirstName());
            prepStatWriter.setString(3, writer.getLastName());
            prepStatWriter.setLong(4, writer.getRegion().getId());
            prepStatWriter.executeUpdate();
            List<Post> postList = writer.getPosts();
            for(Post p : postList ) {
                prepStatWriterPost.setLong(1, id);
                prepStatWriterPost.setLong(2, p.getId());
                prepStatWriterPost.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Problem with create Writer");
        }
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writerList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement prepStatWriter = connection.prepareStatement(WriterDirectory.WRITER_GET_ALL);
            ResultSet resultWriter = prepStatWriter.executeQuery()){
            while (resultWriter.next()) {
                Writer writer = new Writer();
                long id = resultWriter.getLong(1);
                writer.setId(id);
                writer.setFirstName(resultWriter.getString(2));
                writer.setLastName(resultWriter.getString(3));
                writer.setRegion(new RegionRepositoryImp().getById(resultWriter.getLong(4)));
                List<Post> postList = getAllPost(id);
                writer.setPosts(postList);
                writerList.add(writer);
            }
        } catch (SQLException e) {
            System.out.println("Problem with getAll Writer");
        }
        return writerList;
    }

    private List<Post> getAllPost(Long id) {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement prepStatWriterPost = connection.prepareStatement(WriterDirectory.WRITER_POST_GET_ALL);
             ResultSet resultWritePost = prepStatWriterPost.executeQuery()) {
            while (resultWritePost.next()) {
                long writerId = resultWritePost.getLong(1);
                long postId = resultWritePost.getLong(2);
                if (writerId == id) {
                    postList.add(new PostRepositoryImpl().getById(postId));
                }
            }
        } catch (SQLException e) {
            System.out.println("Problem with getAll from table writepost");
        }
        return postList;
    }

    @Override
    public Writer getById(Long id) {
        return getAll().stream().
                filter(writer -> writer.getId().equals(id)).
                findFirst().orElse(null);
    }

    @Override
    public Writer update(Writer writer) {
        try (Connection connection = getConnection();
             PreparedStatement prepStatWriter = connection.prepareStatement(WriterDirectory.WRITER_UPDATE);
             PreparedStatement prepStatWriterPost = connection.prepareStatement(WriterDirectory.WRITER_POST_CREATE);
             PreparedStatement prepStatWriterPostAllDelete = connection.prepareStatement(WriterDirectory.WRITER_POST_ALL_DELETE)) {
            long id = writer.getId();
            prepStatWriter.setString(1, writer.getFirstName());
            prepStatWriter.setString(2, writer.getLastName());
            prepStatWriter.setLong(3, writer.getRegion().getId());
            prepStatWriter.setLong(4, id);
            prepStatWriter.executeUpdate();
            prepStatWriterPostAllDelete.setLong(1, id);
            prepStatWriterPostAllDelete.executeUpdate();
            List<Post> postList = writer.getPosts();
            for(Post p : postList ) {
                prepStatWriterPost.setLong(1, id);
                prepStatWriterPost.setLong(2, p.getId());
                prepStatWriterPost.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Problem with update Writer");
        }
        return writer;
    }

    @Override
    public void remove(Long id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(WriterDirectory.WRITER_DELETE);
             PreparedStatement prepStatWriterPostAllDelete = connection.prepareStatement(WriterDirectory.WRITER_POST_ALL_DELETE)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            prepStatWriterPostAllDelete.setLong(1,id);
            prepStatWriterPostAllDelete.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem with Delete Writer");
        }
    }
    private Long generateId(){
        if(!getAll().isEmpty()){
             return getAll().stream()
                    .skip(getAll().size()-1)
                    .findFirst().get().getId()+1;
        }else
            return 1L;
    }
}
