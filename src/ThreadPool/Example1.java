package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i = 1; i<=5; i++)
        {
            int taskId = i;
            service.submit(
                    ()-> System.out.println("Task "+taskId + " executed by "+ Thread.currentThread().getName()
            ));
        }
        service.shutdown();
    }
}
