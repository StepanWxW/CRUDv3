import model.Region;
import repository.RegionRepositoryImp;

public class Start {
    public static void main(String[] args) {
        RegionRepositoryImp repositoryImp = new RegionRepositoryImp();
//        repositoryImp.create(new Region("Tomsk"));
        repositoryImp.create(new Region("MOs"));
//        repositoryImp.create(new Region("SEVERSK"));
//        System.out.println(repositoryImp.getAll());
//        System.out.println(repositoryImp.getByID(9L));
    }
}
