package Thread;

class JoinDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " → " + i);
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo t1 = new JoinDemo();
        JoinDemo t2 = new JoinDemo();

        t1.start();  // Start first thread

        t1.join();   // Main thread waits for t1 to finish before continuing

        t2.start();  // Only starts after t1 is done


        System.out.println("Main thread finished.");
    }
}