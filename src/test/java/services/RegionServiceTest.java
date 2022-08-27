package services;

import model.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RegionServiceTest {
    RegionService regionService;

    @Before
    public void createRegionService() {
        regionService = new RegionService();
    }

    @Test
    public void createRegionShouldBeInGetAll() {
        Region regionTest = new Region("Test_name");
        regionService.create(regionTest);
        List<Region> regionList = regionService.getAll();
        Region regionIn = new Region();
        for (Region r : regionList) {
            if (r.getName().equals(regionTest.getName())) {
                regionIn = r;
            }
        }
        Assert.assertEquals(regionIn.getName(), regionTest.getName());
    }

    @Test
    public void getAllRegionShouldBeDifferentId() {
        regionService.create(new Region("Test1"));
        regionService.create(new Region("Test2"));
        regionService.create(new Region("Test3"));
        List<Region> regionList = regionService.getAll();
        Region regionIn = new Region();
        for (Region r : regionList) {
            Assert.assertNotEquals(regionIn.getId(), r.getId());
            regionIn = r;
        }
    }

    @Test
    public void deleteRegionShouldBeDeleted() {
        Region region = new Region("TestDeleted");
        regionService.create(region);
        List<Region> regionList = regionService.getAll();
        Long id;
        for (Region r : regionList) {
            if (r.getName().equals(region.getName())) {
                id = r.getId();
                regionService.remove(id);
            }
        }
        List<Region> regionList2 = regionService.getAll();
        for (Region r2 : regionList2) {
            Assert.assertNotEquals(region.getName(), r2.getName());
        }
    }

    @Test
    public void updateRegionShouldBeUpdate() {
        Region region = new Region("TestUpdate");
        List<Region> regionList = regionService.getAll();
        Long id;
        Region regionUp;
        for (Region r : regionList) {
            if (r.getName().equals(region.getName())) {
                id = r.getId();
                regionUp = new Region(id,"TestUpIsSuccessful");
                regionService.update(regionUp);
                Assert.assertEquals(regionService.getById(id), new Region(id, "TestUpIsSuccessful"));
            }
        }
    }
}