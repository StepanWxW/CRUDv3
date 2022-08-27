package controller;

import model.Post;
import services.PostService;

import java.util.List;

public class PostController {
    private PostService service = new PostService();
    public Post create(Post post) {
        return service.create(post);
    }

    public List<Post> getAll() {
        return service.getAll();
    }

    public Post getById(Long id) {
        return service.getById(id);
    }
    public void remove(Long id) {
        service.remove(id);
    }
    public Post update(Post post) {
        return service.update(post);
    }
}
