package Synchronization;

public class PenPaperDeadlock {
    private final Object pen = new Object();
    private final Object paper = new Object();

    // Thread 1 wants pen first, then paper
    public void writeWithPenFirst() {
        synchronized (pen) {
            System.out.println(Thread.currentThread().getName() + " picked up the Pen.");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " waiting for the Paper...");
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " got the Paper and starts writing!");
            }
        }
    }

    // Thread 2 wants paper first, then pen
    public void writeWithPaperFirst() {
        synchronized (paper) {
            System.out.println(Thread.currentThread().getName() + " picked up the Paper.");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " waiting for the Pen...");
            synchronized (pen) {
                System.out.println(Thread.currentThread().getName() + " got the Pen and starts writing!");
            }
        }
    }

    public static void main(String[] args) {
        PenPaperDeadlock table = new PenPaperDeadlock();

        Thread t1 = new Thread(table::writeWithPenFirst, "Writer-1");
        Thread t2 = new Thread(table::writeWithPaperFirst, "Writer-2");

        t1.start();
        t2.start();
    }
}