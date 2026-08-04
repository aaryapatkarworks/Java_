import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _02_CollectionVsCollections {

    public static void main(String[] args) {

        // Collection interface reference
        Collection<String> technologies = new ArrayList<>();

        technologies.add("Java");
        technologies.add("Python");
        technologies.add("Spring Boot");

        System.out.println("Collection:");
        System.out.println(technologies);

        // List implementation for sorting
        List<Integer> marks = new ArrayList<>();

        marks.add(82);
        marks.add(95);
        marks.add(75);
        marks.add(89);

        System.out.println("\nBefore Sorting:");
        System.out.println(marks);

        // Collections utility class
        Collections.sort(marks);

        System.out.println("\nAfter Sorting:");
        System.out.println(marks);
    }
}