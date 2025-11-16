package ExecutorService;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo2 {
    public static void main(String[] args) {

        // A barrier for 3 worker threads
        CyclicBarrier barrier = new CyclicBarrier(3);

        ExecutorService service = Executors.newFixedThreadPool(3);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " reached the barrier and is WAITING...");

            try {
                // Worker threads WAIT here
                barrier.await();
            } catch (Exception e) {}

            System.out.println(Thread.currentThread().getName() + " passed the barrier and CONTINUES...");
        };

        // Submit 3 workers
        service.submit(worker);
        service.submit(worker);
        service.submit(worker);

        // MAIN THREAD DOES NOT WAIT
        System.out.println(Thread.currentThread().getName()+" -> Main thread is doing other work...");
        System.out.println(Thread.currentThread().getName()+ " -> Main thread is not waiting for workers!");
        System.out.println(Thread.currentThread().getName()+ " -> Main thread finished its own tasks.");

        service.shutdown();
    }
}
