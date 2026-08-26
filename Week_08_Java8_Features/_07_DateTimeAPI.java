import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class _07_DateTimeAPI {

    public static void main(String[] args) {

        // 1. LocalDate - date without time
        LocalDate joiningDate =
                LocalDate.of(2026, 8, 26);

        System.out.println(
                "Joining Date: " + joiningDate
        );


        // 2. LocalTime - time without date
        LocalTime loginTime =
                LocalTime.of(10, 30);

        System.out.println(
                "Login Time: " + loginTime
        );


        // 3. LocalDateTime - date and time
        LocalDateTime loginDateTime =
                LocalDateTime.of(
                        joiningDate,
                        loginTime
                );

        System.out.println(
                "Login Date-Time: " + loginDateTime
        );


        // 4. Adding and subtracting time
        LocalDate projectDeadline =
                joiningDate.plusDays(30);

        LocalDate previousDate =
                joiningDate.minusDays(7);

        System.out.println(
                "Project Deadline: " + projectDeadline
        );

        System.out.println(
                "Previous Date: " + previousDate
        );


        // 5. Period - difference between dates
        LocalDate projectStart =
                LocalDate.of(2026, 1, 1);

        Period projectDuration =
                Period.between(
                        projectStart,
                        joiningDate
                );

        System.out.println(
                "Project Duration: "
                        + projectDuration.getMonths()
                        + " months and "
                        + projectDuration.getDays()
                        + " days"
        );


        // 6. Duration - difference between times
        LocalTime startTime =
                LocalTime.of(10, 0);

        LocalTime endTime =
                LocalTime.of(12, 30);

        Duration workDuration =
                Duration.between(
                        startTime,
                        endTime
                );

        System.out.println(
                "Work Duration: "
                        + workDuration.toHours()
                        + " hours "
                        + (workDuration.toMinutes() % 60)
                        + " minutes"
        );


        // 7. DateTimeFormatter - formatting
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy"
                );

        String formattedDate =
                joiningDate.format(formatter);

        System.out.println(
                "Formatted Date: " + formattedDate
        );


        // 8. Parsing a formatted date
        LocalDate parsedDate =
                LocalDate.parse(
                        "15-09-2026",
                        formatter
                );

        System.out.println(
                "Parsed Date: " + parsedDate
        );


        // 9. Instant - UTC timestamp
        Instant timestamp =
                Instant.now();

        System.out.println(
                "UTC Timestamp: " + timestamp
        );


        // 10. ZonedDateTime - date and time with timezone
        ZonedDateTime indiaTime =
                ZonedDateTime.now(
                        ZoneId.of("Asia/Kolkata")
                );

        System.out.println(
                "India Time: " + indiaTime
        );
    }
}