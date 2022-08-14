import model.Region;
import repository.implementation.RegionRepositoryImp;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        RegionRepositoryImp regionRepositoryImp = new RegionRepositoryImp();
        regionRepositoryImp.create(new Region("DFS"));
        System.out.println(regionRepositoryImp.getAll());
        String s =  new Scanner(System.in).nextLine();
   }
}
