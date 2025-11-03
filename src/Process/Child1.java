package Process;

public class Child1 {
    public static void main(String[] args) {

        // ✅ Step 1: Print current process PID
        System.out.println("Child PID: " + ProcessHandle.current().pid());

        // ✅ Step 2: Calculate area of circle
        int radius = 10;
        double areaCircle = 3.14 * radius * radius;
        System.out.println("Area of Circle (Child): " + areaCircle);

        // ✅ Step 3: Simulate processing time
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Child process finished execution.");
    }
}