package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1Demo {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(1);

        Runnable circleTask = () -> {
            double radius = 7;
            double area = Math.PI * radius * radius;

            String formattedArea = String.format("%.3f", area);

            System.out.println("Area of Circle " + formattedArea +
                    " calculated by -> " + Thread.currentThread().getName());
        };

        Runnable squareTask = () -> {
            double side = 5;
            double area = side * side;
            System.out.println("Square Area: " + area + " Calculated by "+
                    " → " + Thread.currentThread().getName());
        };

        service.submit(circleTask);
        service.submit(squareTask);
        service.shutdown();
    }
}
