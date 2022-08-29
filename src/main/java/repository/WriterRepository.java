package repository;

import model.Writer;

import java.util.List;


public interface WriterRepository extends GenericRepository<Writer,Long> {
    @Override
    Writer create(Writer writer);
    @Override
    List<Writer> getAll();
    @Override
    Writer getById(Long id);
    @Override
    Writer update(Writer user);
    @Override
    void remove(Long id);
}
