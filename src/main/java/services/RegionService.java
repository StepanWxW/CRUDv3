package services;

import model.Region;
import repository.implementation.RegionRepositoryImp;

import java.util.List;

public class RegionService {


    private RegionRepositoryImp repository;

    public RegionService() {
        this.repository = new RegionRepositoryImp();
    }
    public RegionService(RegionRepositoryImp repository) {
        this.repository = repository;
    }
    public RegionRepositoryImp getRepository() {
        return repository;
    }

    public Region create(Region region) {
        return repository.create(region);
    }

    public List<Region> getAll() {
        return repository.getAll();
    }

    public Region getById(Long id) {
        return repository.getById(id);
    }
    public void remove(Long id) {
        repository.remove(id);
    }
    public Region update(Region region) {
        return repository.update(region);
    }
}
