package ExecutorService;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " reached barrier...");

            try {
                barrier.await();  // WAIT here
            } catch (Exception e) {}

            System.out.println(Thread.currentThread().getName() + " proceeding...");
        };

        service.submit(task);
        service.submit(task);
        service.submit(task);

        service.shutdown();
    }
}
