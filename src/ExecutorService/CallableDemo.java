package ExecutorService;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            int sum =0;
            for(int i=1;i<=10;i++)
            {
                sum+=i;
            }
            return sum;
        };

        Future<Integer> result = service.submit(task);
        try {
            System.out.println("Result:- "+ result.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        service.shutdown();
    }
}
