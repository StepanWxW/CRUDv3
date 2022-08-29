package repository;

import model.Post;

import java.util.List;

public interface PostRepository extends GenericRepository<Post,Long> {
    @Override
    Post create(Post post);

    @Override
    List<Post> getAll();

    @Override
    Post getById(Long id);

    @Override
    Post update(Post post);

    @Override
    void remove(Long id);
}
