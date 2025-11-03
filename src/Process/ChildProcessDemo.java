package Process;

public class ChildProcessDemo {
    public static void main(String[] args) {
        System.out.println("Hello! I am a separate process.");
        System.out.println("My PID is: " + ProcessHandle.current().pid());

        try {
            Thread.sleep(5000); // Stay alive for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Child process exiting...");
    }
}