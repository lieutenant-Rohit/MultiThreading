package Process;

import java.io.IOException;

public class Parent1 {
    public static void main(String[] args) throws IOException, InterruptedException {

        // ✅ Step 1: Create a ProcessBuilder to run the compiled Child1 class
        ProcessBuilder pb = new ProcessBuilder("java", "/Users/geek/Documents/Java/MultiThreading/src/Process/Child1.java");

        // ✅ Step 2: Print parent process ID
        System.out.println("Parent PID: " + ProcessHandle.current().pid());

        // ✅ Step 3: Do some work in the parent process
        int length = 10;
        int breadth = 5;
        double areaTriangle = 0.5 * length * breadth;
        System.out.println("Area of Triangle (Parent): " + areaTriangle);

        // ✅ Step 4: Let child process share same console
        pb.inheritIO();

        // ✅ Step 5: Start the child process
        Process process = pb.start();
        System.out.println("Child process (Child1) created with PID: " + process.pid());

        // ✅ Step 6: Wait for the child process to finish
        int exitCode = process.waitFor();
        System.out.println("Child exited with code: " + exitCode);
    }
}