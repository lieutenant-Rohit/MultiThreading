package ExecutorService;

import java.util.concurrent.*;

public class SemaphoreDemo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2); // 2 permits

        ExecutorService service = Executors.newFixedThreadPool(5);

        Runnable task = () -> {
            try {
                semaphore.acquire();  // take permit
                System.out.println(Thread.currentThread().getName() + " got access");

                Thread.sleep(2000); // simulate work

                System.out.println(Thread.currentThread().getName() + " releasing access");
                semaphore.release();  // release permit

            } catch (Exception e) {}
        };

        for (int i = 1; i <= 5; i++) {
            service.submit(task);
        }

        service.shutdown();
    }
}