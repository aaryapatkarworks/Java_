import java.io.FileReader;
import java.io.IOException;

public class _05_FileReader {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("student.txt")) {

            int ch;

            System.out.println("File Contents:\n");

            // Read until end of file (-1)
            while ((ch = reader.read()) != -1) {

                System.out.print((char) ch);

            }

        }

        catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}