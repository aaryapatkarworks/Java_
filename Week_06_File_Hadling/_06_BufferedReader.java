import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _06_BufferedReader {

    public static void main(String[] args) {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("student.txt"))) {

            String line;

            System.out.println("File Contents:\n");

            // Read one line at a time until end of file
            while ((line = reader.readLine()) != null) {

                System.out.println(line);

            }

        }

        catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}