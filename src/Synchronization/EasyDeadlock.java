package Synchronization;

public class EasyDeadlock {
    public static void main(String[] args) {
        final Object lockA = new Object();
        final Object lockB = new Object();

        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1: locked lockA");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: waiting to lock lockB");
                synchronized (lockB) {
                    System.out.println("Thread 1: locked lockB");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2: locked lockB");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: waiting to lock lockA");
                synchronized (lockA) {
                    System.out.println("Thread 2: locked lockA");
                }
            }
        });

        t1.start();
        t2.start();
    }
}