import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class _04_BufferedWriter {

    public static void main(String[] args) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("student.txt", true))) {

            writer.write("Student Name : Shelly");
            writer.newLine();

            writer.write("Course : B.Tech CSE AI-DS");
            writer.newLine();

            writer.write("Semester : 7");
            writer.newLine();

            writer.write("CGPA : 9.10");

            System.out.println("Data written successfully using BufferedWriter.");

        }

        catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

}