package services;

import model.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.implementation.RegionRepositoryImp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RegionServiceTest {
    private RegionService regionService;
    private RegionRepositoryImp mokRepository = mock(RegionRepositoryImp.class);
    @Before
     public void init () {
       mokRepository = mock(RegionRepositoryImp.class);
       regionService = new RegionService(mokRepository);
    }

    @Test
    public void getAllRegionShouldReturnAllRegion() {
        // given
        List<Region> expected = new ArrayList<>();
        Region region1 = new Region("Tomsk");
        Region region2 = new Region("Moscow");
        Region region3 = new Region("Seversk");
        expected.add(region1);
        expected.add(region2);
        expected.add(region3);
        // when
        when(mokRepository.getAll()).thenReturn(expected);
        List<Region> actual = regionService.getAll();
        // then
        assertEquals(expected, actual);
        assertNotNull(actual);
        verify(mokRepository, times(1)).getAll();
    }
}