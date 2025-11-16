package ThreadLocal;

public class ThreadLocalDemo {
    static ThreadLocal<Integer> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        Runnable task = () -> {
            tl.set((int)(Math.random() * 100));   // each thread stores its own value
            System.out.println(Thread.currentThread().getName() + " value = " + tl.get());
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
