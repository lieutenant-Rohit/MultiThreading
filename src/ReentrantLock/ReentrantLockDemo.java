package ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Runnable task = () -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " got the lock");
                Thread.sleep(1000);
            } catch (Exception e) {}
            finally {
                System.out.println(Thread.currentThread().getName() + " releasing the lock");
                lock.unlock();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }
}
