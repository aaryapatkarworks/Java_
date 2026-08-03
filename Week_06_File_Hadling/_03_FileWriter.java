import java.io.FileWriter;
import java.io.IOException;

public class _03_FileWriter {

    public static void main(String[] args) {

        overwriteExample();

        appendExample();

    }

    // Default Mode -> Existing content will be replaced
    static void overwriteExample() {

        try (FileWriter writer = new FileWriter("student.txt")) {

            writer.write("Student Name : Aarya\n");
            writer.write("Course       : B.Tech CSE\n");
            writer.write("Semester     : 7\n");

            System.out.println("Data written successfully (Overwrite Mode).");

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

    // Append Mode -> New content is added to the existing file
    static void appendExample() {

        try (FileWriter writer = new FileWriter("student.txt", true)) {

            writer.write("CGPA         : 9.10\n");
            writer.write("College      : MIT-WPU\n");

            System.out.println("Data appended successfully.");

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}