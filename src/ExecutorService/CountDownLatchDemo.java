package ExecutorService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        Runnable task = () -> {
            System.out.println("Task Executed By "+ Thread.currentThread().getName());

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            latch.countDown();
        };

        service.submit(task);
        service.submit(task);
        service.submit(task);

        latch.await();

        System.out.println("All Task Completed");
        service.shutdown();
    }
}
