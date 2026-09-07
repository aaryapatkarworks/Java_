package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.learning.spring")
public class _10_StereotypeAnnotations {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _10_StereotypeAnnotations.class
                );

        GeneralComponent component =
                context.getBean(GeneralComponent.class);

        PaymentService service =
                context.getBean(PaymentService.class);

        StudentRepository repository =
                context.getBean(StudentRepository.class);

        StudentController controller =
                context.getBean(StudentController.class);


        component.execute();

        service.processPayment();

        repository.save();

        controller.handleRequest();
    }
}


/*
 * General-purpose component
 */

@Component
class GeneralComponent {

    public void execute() {

        System.out.println(
                "General Component executed"
        );
    }
}


/*
 * Business Logic Layer
 */

@Service
class PaymentService {

    public void processPayment() {

        System.out.println(
                "Payment processed"
        );
    }
}


/*
 * Data Access Layer
 */

@Repository
class StudentRepository {

    public void save() {

        System.out.println(
                "Student saved to database"
        );
    }
}


/*
 * Presentation Layer
 */

@Controller
class StudentController {

    public void handleRequest() {

        System.out.println(
                "Student request handled"
        );
    }
}