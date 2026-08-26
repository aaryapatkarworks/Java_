import java.util.Optional;

public class _06_Optional {

    public static void main(String[] args) {

        // 1. Optional.of() - value is known to be non-null
        Optional<String> employeeName =
                Optional.of("Aarya Patkar");

        System.out.println(
                "Employee: " + employeeName.get()
        );


        // 2. Optional.ofNullable() - value may be null
        String department = null;

        Optional<String> employeeDepartment =
                Optional.ofNullable(department);

        System.out.println(
                "Department Present: "
                        + employeeDepartment.isPresent()
        );


        // 3. ifPresent() - perform an action if value exists
        employeeName.ifPresent(
                name -> System.out.println(
                        "Name: " + name
                )
        );


        // 4. orElse() - provide a default value
        String departmentName =
                employeeDepartment.orElse(
                        "Not Assigned"
                );

        System.out.println(
                "Department: " + departmentName
        );


        // 5. orElseGet() - generate a fallback value
        String fallbackDepartment =
                employeeDepartment.orElseGet(
                        () -> "General Department"
                );

        System.out.println(
                "Fallback Department: "
                        + fallbackDepartment
        );


        // 6. map() - transform the value if present
        Optional<String> upperCaseName =
                employeeName.map(String::toUpperCase);

        System.out.println(
                "Uppercase Name: "
                        + upperCaseName.orElse("Unknown")
        );


        // 7. orElseThrow() - throw an exception if empty
        String verifiedName =
                employeeName.orElseThrow(
                        () -> new IllegalStateException(
                                "Employee name is missing"
                        )
                );

        System.out.println(
                "Verified Name: " + verifiedName
        );
    }
}