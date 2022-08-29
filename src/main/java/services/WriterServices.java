package services;

import model.Writer;
import repository.implementation.WriteRepositoryImpl;

import java.util.List;

public class WriterServices {
    private WriteRepositoryImpl repository = new WriteRepositoryImpl();
    public Writer create(Writer writer) {
        return repository.create(writer);
    }

    public List<Writer> getAll() {
        return repository.getAll();
    }

    public Writer getById(Long id) {
        return repository.getById(id);
    }
    public void remove(Long id) {
        repository.remove(id);
    }
    public Writer update(Writer writer) {
        return repository.update(writer);
    }
}
