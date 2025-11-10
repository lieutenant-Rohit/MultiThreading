package ThreadPriority;

class PriorityDemo extends Thread {
    public PriorityDemo(String name) {
        super(name);
    }

    public  void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is running with priority " + getPriority());
        }
    }

    public static void main(String[] args) {
        PriorityDemo t1 = new PriorityDemo("Low Priority Thread");
        PriorityDemo t2 = new PriorityDemo("Normal Priority Thread");
        PriorityDemo t3 = new PriorityDemo("High Priority Thread");

        t1.setPriority(Thread.MIN_PRIORITY);  // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t3.setPriority(Thread.MAX_PRIORITY);  // 10

        t1.start();
        t2.start();
        t3.start();
    }
}