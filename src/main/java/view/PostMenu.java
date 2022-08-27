package view;


import controller.PostController;
import directory.MenuDirectory;
import model.Post;
import model.PostStatus;

import java.util.Scanner;

public class PostMenu {
        PostController postController = new PostController();
    public void startPostMenu() {
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
        System.out.println("Enter Post please:");
        String post = scanLine();
        System.out.println(ACTIVE_DELETED);
        PostStatus anEnum = roleAdd();
        postController.create(new Post(post, anEnum));
        System.out.println("Congratulation: create is complete.");
    }
    private void readAll() {
        String[] words = postController.getAll().toString().split("},");
        for (String word : words) {
            System.out.println(word);
        }
    }
    private void readId() {
        System.out.println("Enter id post please:");
        try {
            Long readId = Long.valueOf(scanLine());
            Post post = postController.getById(readId);
            if (post != null) {
                System.out.println(post);
            } else {
                System.out.println("This post is missing");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    private void deleteId() {
        System.out.println("Enter id to delete post please:");
        try {
            Long readId = Long.valueOf(scanLine());
            postController.remove(readId);
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    private void updateId() {
        System.out.println("Enter id to update post please:");
        try {
            Long readId = Long.valueOf(scanLine());
            if(postController.getById(readId) != null) {
                System.out.println("Enter please new post for id: " +readId);
                String postUp = scanLine();
                System.out.println(ACTIVE_DELETED);
                PostStatus anEnum = roleAdd();
                postController.update(new Post(readId, postUp,anEnum));
            } else {
                System.out.println("This post is missing");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input number please");
        }
    }
    protected PostStatus roleAdd() {
        PostStatus anEnum = null;
        boolean flagRole = true;
        while (flagRole) {
            String s = scanLine();
            switch (s) {
                case ("1"): case ("ACTIVE"): anEnum = PostStatus.ACTIVE; flagRole = false; break;
                case ("2"): case ("DELETED"): anEnum = PostStatus.DELETED; flagRole = false; break;
                default:
                    System.out.println(ACTIVE_DELETED);
            }
        }
        return anEnum;
    }
    private String scanLine(){
        return new Scanner(System.in).nextLine();
    }
    private final String ACTIVE_DELETED = "Enter please: \"ACTIVE\", \"DELETED\" " +
            "or \"1\", \"2\".";
}

