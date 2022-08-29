package controller;

import model.Region;
import repository.implementation.RegionRepositoryImp;
import services.RegionService;

import java.util.List;

public class RegionController {

    RegionService service = new RegionService();

    public Region create(Region region) {
        return service.create(region);
    }

    public List<Region> getAll() {
        return service.getAll();
    }

    public Region getById(Long id) {
        return service.getById(id);
    }
    public void remove(Long id) {
        service.remove(id);
    }
    public Region update(Region region) {
        return service.update(region);
    }
}
