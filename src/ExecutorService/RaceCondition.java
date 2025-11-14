package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//class Counter{
//    int count=0;
//}

class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
public class RaceCondition {
    public static void main(String[] args) {

        Counter c = new Counter();
        ExecutorService service = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();  // ✔ Thread-safe now
            }
        };

        service.submit(task);
        service.submit(task);
        service.submit(task);

        service.shutdown();

        // small delay to allow tasks to finish
        try { Thread.sleep(1000); } catch (Exception e) {}

        System.out.println("Final count: " + c.count);
    }
}