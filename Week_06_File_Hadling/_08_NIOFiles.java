import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class _08_NIOFiles {

    public static void main(String[] args) {

        Path filePath = Paths.get("employee.txt");

        try {

            // Create File
            if (!Files.exists(filePath)) {

                Files.createFile(filePath);
                System.out.println("File created successfully.");

            } else {

                System.out.println("File already exists.");

            }

            // Write Data (Overwrites existing content)
            Files.writeString(filePath,
                    "Employee ID : 101\n" +
                            "Name : Shelly\n" +
                            "Department : AI-DS");

            System.out.println("\nData written successfully.");

            // Read Entire File
            String data = Files.readString(filePath);

            System.out.println("\nFile Contents:");
            System.out.println(data);

            // Read Line by Line
            List<String> lines = Files.readAllLines(filePath);

            System.out.println("\nReading Line by Line:");

            for (String line : lines) {

                System.out.println(line);

            }

            // Copy File
            Path copyPath = Paths.get("employee_copy.txt");

            Files.copy(filePath, copyPath,
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("\nFile copied successfully.");

            // Move / Rename File
            Path movedPath = Paths.get("employee_data.txt");

            Files.move(copyPath, movedPath,
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File moved/renamed successfully.");

            // File Information
            System.out.println("\nFile Exists : "
                    + Files.exists(filePath));

            System.out.println("File Size : "
                    + Files.size(filePath) + " bytes");

            System.out.println("Is Regular File : "
                    + Files.isRegularFile(filePath));

            System.out.println("Is Directory : "
                    + Files.isDirectory(filePath));

            // Delete File
            Files.deleteIfExists(movedPath);

            System.out.println("\nCopied file deleted successfully.");

        }

        catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}