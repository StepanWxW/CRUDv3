package repository;

import model.Region;

import java.util.List;

public interface RegionRepository extends GenericRepository<Region, Long> {

    @Override
    Region create(Region region);

    @Override
    List<Region> getAll();

    @Override
    Region getById(Long id);

    @Override
    Region update(Region region);

    @Override
    void remove(Long id);
}
