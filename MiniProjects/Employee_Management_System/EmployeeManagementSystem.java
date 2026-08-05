import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Employee ID : ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Employee Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Salary : ");
            double salary = sc.nextDouble();

            addEmployee(id, name, salary);

            System.out.println("\nEmployee Added Successfully!\n");

            for (Employee employee : employees) {

                System.out.println(employee);
                System.out.println("-------------------------");

            }

        }

        catch (InvalidSalaryException e) {

            System.out.println(e.getMessage());

        }

        catch (Exception e) {

            System.out.println("Unexpected Error : " + e.getMessage());

        }

    }

    static void addEmployee(int id,
                            String name,
                            double salary)
            throws InvalidSalaryException {

        validateSalary(salary);

        Employee employee = new Employee(id, name, salary);

        employees.add(employee);

    }

    static void validateSalary(double salary)
            throws InvalidSalaryException {

        if (salary < 15000) {

            throw new InvalidSalaryException(
                    "Salary must be at least ₹15000."
            );

        }

    }

}