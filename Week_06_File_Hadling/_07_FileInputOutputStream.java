import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_FileInputOutputStream {

    public static void main(String[] args) {

        // Copy student.txt into student_copy.txt

        try (
                FileInputStream input =
                        new FileInputStream("student.txt");

                FileOutputStream output =
                        new FileOutputStream("student_copy.txt")
        ) {

            int data;

            // Read one byte at a time and write it to the new file
            while ((data = input.read()) != -1) {

                output.write(data);

            }

            System.out.println("File copied successfully.");

        }

        catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}