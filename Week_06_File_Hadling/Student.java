import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    double cgpa;

    transient String password;

    public Student(int id, String name, double cgpa, String password) {

        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
        this.password = password;

    }

    @Override
    public String toString() {

        return "Student ID : " + id +
                "\nName : " + name +
                "\nCGPA : " + cgpa +
                "\nPassword : " + password;

    }

}