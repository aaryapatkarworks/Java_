import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class _09_Serialization {

    public static void main(String[] args) {

        Student student =
                new Student(101,
                        "Shelly",
                        9.10,
                        "abc123");

        serializeStudent(student);

        deserializeStudent();

    }

    static void serializeStudent(Student student) {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream("student.ser"))) {

            output.writeObject(student);

            System.out.println("Object serialized successfully.");

        }

        catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

    static void deserializeStudent() {

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream("student.ser"))) {

            Student student = (Student) input.readObject();

            System.out.println("\nDeserialized Object:\n");

            System.out.println(student);

        }

        catch (IOException | ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

}