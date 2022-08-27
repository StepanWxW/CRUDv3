package view;


import directory.MenuDirectory;
import model.Region;
import repository.implementation.RegionRepositoryImp;

import java.util.Scanner;

public class RegionMenu {
    RegionRepositoryImp regionRepository = new RegionRepositoryImp();

    public void startRegionMenu() {
        System.out.println(MenuDirectory.MAIN_MENU);
        switch (scanLine()) {
            case ("1"):
                create();
                break;
            case ("2"):
                readAll();
                break;
            case ("3"):
                readId();
                break;
            case ("4"):
                deleteId();
                break;
            case ("5"):
                updateId();
                break;
        }
    }
    private void create() {
        System.out.println("Enter Region please:");
        regionRepository.create(new Region(scanLine()));
        System.out.println("Congratulation: create is complete.");
    }
    private void readAll() {
        String[] words = regionRepository.getAll().toString().split("},");
        for (String word : words) {
            System.out.println(word);
        }
    }
    private void readId() {
        System.out.println("Enter id region please:");
        try {
            Long readId = Long.valueOf(scanLine());
            Region region = regionRepository.getByID(readId);
            if (region != null) {
                System.out.println(region);
            } else {
                System.out.println("This region is missing");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
            }
    private void deleteId() {
        System.out.println("Enter id to delete region please:");
        try {
            Long readId = Long.valueOf(scanLine());
                regionRepository.remove(readId);
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    private void updateId() {
        System.out.println("Enter id to update region please:");
        try {
            Long readId = Long.valueOf(scanLine());
            if(regionRepository.getByID(readId) != null) {
                System.out.println("Enter please new region for id: " +readId);
                regionRepository.update(new Region(readId, scanLine()));
            } else {
                System.out.println("This region is missing");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    private String scanLine(){
        return new Scanner(System.in).nextLine();
    }
}
