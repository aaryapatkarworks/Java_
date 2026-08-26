import java.util.Arrays;
import java.util.List;

interface Calculator {
    int calculate(int a, int b);
}

public class _01_LambdaExpression {

    public static void main(String[] args) {

        Calculator addition = (a, b) -> a + b;

        System.out.println(addition.calculate(10, 20));

        List<String> employees = Arrays.asList(
                "Aarya Patkar",
                "Pranav More",
                "Arnav Jadhav",
                "Pratiksha Kulkarni"
        );

        employees.forEach(name -> System.out.println(name));
    }
}