import java.io.File;
import java.io.IOException;

public class _02_FileClass {

    public static void main(String[] args) throws IOException {

        // Creating a File object (represents the file path)
        File file = new File("student.txt");

        System.out.println("File Name      : " + file.getName());

        System.out.println("Absolute Path  : " + file.getAbsolutePath());

        // Check whether the file already exists
        if (file.exists()) {

            System.out.println("File already exists.");

        } else {

            // Create a new empty file
            if (file.createNewFile()) {

                System.out.println("File created successfully.");

            } else {

                System.out.println("Failed to create file.");

            }

        }

        System.out.println("Is File        : " + file.isFile());

        System.out.println("Is Directory   : " + file.isDirectory());

        System.out.println("File Size      : " + file.length() + " bytes");

        System.out.println();

        // Creating a folder
        File folder = new File("StudentData");

        if (folder.mkdir()) {

            System.out.println("Folder created successfully.");

        } else {

            System.out.println("Folder already exists.");

        }

        // Creating multiple folders
        File folders = new File("Data/2026/August");

        folders.mkdirs();

        System.out.println("Nested folders checked/created.");

    }

}