public class _09_ModernJavaFeatures {

    public static void main(String[] args) {

        // 1. var - local variable type inference
        var employeeName = "Aarya Patkar";
        var employeeExperience = 2;

        System.out.println(
                "Employee: " + employeeName
        );

        System.out.println(
                "Experience: " + employeeExperience + " years"
        );


        // 2. Enhanced switch expression
        String role = "ADMIN";

        String accessLevel = switch (role) {
            case "ADMIN" -> "Full Access";
            case "USER" -> "Limited Access";
            default -> "Unknown Access";
        };

        System.out.println(
                "Access Level: " + accessLevel
        );


        // 3. Text block
        String employeeJson = """
                  name: Aarya Patkar
                  role: Developer
                """;

        System.out.println(employeeJson);


        // 4. Pattern matching for instanceof
        Object employee = "Aarya Patkar";

        if (employee instanceof String name) {
            System.out.println(
                    "Name Length: " + name.length()
            );
        }


        // 5. Record
        Employee employeeDetails =
                new Employee(
                        "Pranav More",
                        "Backend Developer"
                );

        System.out.println(employeeDetails);
        System.out.println(
                "Employee Name: "
                        + employeeDetails.name()
        );


        // 6. Virtual Thread
        Thread virtualThread =
                Thread.startVirtualThread(() ->
                        System.out.println(
                                "Running on Virtual Thread"
                        )
                );

        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    // Record - compact immutable data carrier
    record Employee(
            String name,
            String designation
    ) {
    }
}