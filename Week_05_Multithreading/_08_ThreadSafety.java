import java.util.concurrent.atomic.AtomicInteger;

class VisitorCounter {

    private AtomicInteger visitors = new AtomicInteger(0);

    public void visit() {

        // Thread-safe increment
        visitors.incrementAndGet();

    }

    public int getVisitors() {

        return visitors.get();

    }

}

public class _08_ThreadSafety {

    public static void main(String[] args) {

        VisitorCounter counter = new VisitorCounter();

        counter.visit();
        counter.visit();
        counter.visit();

        System.out.println("Total Visitors : " + counter.getVisitors());

    }

}