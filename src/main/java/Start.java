
import model.Region;
import repository.RegionRepositoryImp;

public class Start {
    public static void main(String[] args) {
        RegionRepositoryImp repositoryImp = new RegionRepositoryImp();
        repositoryImp.create(new Region("Tomsk"));
//        repositoryImp.create(new Region("MOs"));
        repositoryImp.create(new Region("SEVERSK"));
        System.out.println(repositoryImp.getAll());
        repositoryImp.update(new Region(2L, "ИСК!!"));
        System.out.println(repositoryImp.getByID(2L));
        repositoryImp.remove(3L);
        repositoryImp.remove(15L);
    }
}
