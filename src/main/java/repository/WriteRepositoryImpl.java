package repository;

import model.Writer;
import repository.implementation.WriterRepository;
import util.ConnectMySQL;

import java.util.List;

public class WriteRepositoryImpl extends ConnectMySQL implements WriterRepository {
    @Override
    public Writer create(Writer writer) {
        return null;
    }

    @Override
    public List<Writer> getAll() {
        return null;
    }

    @Override
    public Writer getByID(Long id) {
        return null;
    }

    @Override
    public Writer update(Writer user) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
