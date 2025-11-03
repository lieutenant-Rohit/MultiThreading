package Thread;

public class ThreadClassDemo extends Thread {

    // The code inside run() executes when the thread starts
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " → Count: " + i);
            try {
                Thread.sleep(500); // pause 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        // main() is executed by the "main" thread
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        // Create two child threads
        ThreadClassDemo t1 = new ThreadClassDemo();
        ThreadClassDemo t2 = new ThreadClassDemo();

        // Start the threads
        t1.start(); // starts new thread (calls run() internally)
        t2.start();


        System.out.println("Main thread has started both child threads.");
    }
}

/*
main is your main thread.
	•	t1 and t2 are child threads running simultaneously.
	•	The order of execution changes each time — that’s the JVM’s thread scheduler deciding who runs next.
 */