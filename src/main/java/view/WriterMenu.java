package view;


import directory.MenuDirectory;
import model.Post;
import model.PostStatus;
import model.Region;
import model.Writer;
import repository.RegionRepository;
import repository.implementation.PostRepositoryImpl;
import repository.implementation.RegionRepositoryImp;
import repository.implementation.WriteRepositoryImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class WriterMenu {
    WriteRepositoryImpl writerRepository = new WriteRepositoryImpl();
    public void startUserMenu() {
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
        System.out.println("Enter Writer first name please:");
        String firstName = scanLine();
        System.out.println("Enter Writer last name please:");
        String lastName = scanLine();
        postsAllRead();
        System.out.println("Enter id post and press \"enter\" for next post. \n" +
                "If you want to finish typing, then write \"exit\"");
        List<Post> postList = postsAdd();
        regionAllRead();
        System.out.println("Enter id region please:");
        Region region = regionAdd();
        writerRepository.create(new Writer(firstName, lastName, postList, region));
        System.out.println("Congratulation: Writer create is complete.");
    }
    protected void postsAllRead() {
        String[] words = new PostRepositoryImpl().getAll().toString().split("},");
        for (String word : words) {
            System.out.println(word);
        }
    }

    protected List<Post> postsAdd() {
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        List<Post> postList = new ArrayList<>();
        while (true) {
            String s = scanLine();
            if (s.equals("exit") && !postList.isEmpty()) {
                break;
            }
            if (s.equals("exit")){
                System.out.println("Enter please at least one id");
            }
            else {
                try {
                    Long readId = Long.valueOf(s);
                    if (postRepository.getByID(readId) != null) {
                        postList.add(postRepository.getByID(readId));
                        System.out.println("Post with id: " + s +" add is complete." +
                                "\nPlease enter \"exit\" or add id post.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input number please");

                }
            }
        }
        return postList;
    }
    protected void regionAllRead() {
        RegionRepositoryImp regionRepository = new RegionRepositoryImp();
        String[] words = regionRepository.getAll().toString().split("},");
        for (String word : words) {
            System.out.println(word);
        }
    }
    protected Region regionAdd() {
        RegionRepository regionRepository = new RegionRepositoryImp();
        Region region;
        while (true) {
            String s = scanLine();
            try {
                Long readId = Long.valueOf(s);
                if (regionRepository.getByID(readId) != null) {
                    region = regionRepository.getByID(readId);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input number please");
            }
        }
        return region;
    }
    private void readAll() {
        WriteRepositoryImpl userRepository = new WriteRepositoryImpl();
        String[] words = userRepository.getAll().toString().split("},");
        for (String word : words) {
            System.out.println(word);
        }
    }
    private void readId() {
        WriteRepositoryImpl userRepository = new WriteRepositoryImpl();
        System.out.println("Enter id writer please:");
        try {
            Long readId = Long.valueOf(scanLine());
            if (userRepository.getByID(readId) != null) {
                System.out.println(userRepository.getByID(readId));
            } else {
                System.out.println("This writer is missing");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    private void deleteId() {
        WriteRepositoryImpl userRepository = new WriteRepositoryImpl();
        System.out.println("Enter id to delete Writer please:");
        try {
            Long readId = Long.valueOf(scanLine());
            userRepository.remove(readId);
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    private void updateId() {
        System.out.println("Enter id writer please:");
        try {
            Long readId = Long.valueOf(scanLine());
            if (writerRepository.getByID(readId) != null) {
                System.out.println("Enter NEW Writer first name please:");
                String firstName = scanLine();
                System.out.println("Enter NEW Writer last name please:");
                String lastName = scanLine();
                postsAllRead();
                System.out.println("Enter id post and press \"enter\" for next post. \n" +
                        "If you want to finish typing, then write \"exit\"");
                List<Post> postList = postsAdd();
                regionAllRead();
                System.out.println("Enter id region please:");
                Region region = regionAdd();
                writerRepository.remove(readId);
                writerRepository.update(new Writer(readId, firstName, lastName, postList, region));
                System.out.println("Congratulation: writer update is complete.");
            } else {
                System.out.println("This writer is missing");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    private String scanLine(){
        return new Scanner(System.in).nextLine();
    }
}