package ExecutorService;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) throws Exception {

        // STEP 1: Create a Callable that returns sum
        Callable<Integer> addTask = () -> {
            int a = 10;
            int b = 20;
            return a + b;
        };

        // STEP 2: Wrap Callable inside FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(addTask);

        // STEP 3: Run FutureTask using a Thread
        Thread t = new Thread(futureTask);
        t.start();

        // STEP 4: Get the result
        Integer result = futureTask.get(); // waits for completion

        System.out.println("Sum = " + result);
    }
}