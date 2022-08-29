package services;

import model.Post;
import repository.implementation.PostRepositoryImpl;

import java.util.List;

public class PostService {
    private PostRepositoryImpl repository = new PostRepositoryImpl();

    public Post create(Post post) {
        return repository.create(post);
    }

    public List<Post> getAll() {
        return repository.getAll();
    }

    public Post getById(Long id) {
        return repository.getById(id);
    }
    public void remove(Long id) {
        repository.remove(id);
    }
    public Post update(Post post) {
        return repository.update(post);
    }
}
