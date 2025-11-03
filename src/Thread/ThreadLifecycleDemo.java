package Thread;

public class ThreadLifecycleDemo extends Thread {
    public void run() {
        try {
            System.out.println(getName() + " → State: " + getState()); // RUNNABLE
            Thread.sleep(2000); // Goes to TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycleDemo t1 = new ThreadLifecycleDemo();

        System.out.println("Before start → " + t1.getState()); // NEW
        t1.start();
        System.out.println("After start → " + t1.getState());  // RUNNABLE

        Thread.sleep(500);
        System.out.println("While sleeping → " + t1.getState()); // TIMED_WAITING

        t1.join(); // Wait for thread to finish
        System.out.println("After join → " + t1.getState());    // TERMINATED
    }
}