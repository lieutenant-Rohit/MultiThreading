package Process;

public class ParentProcessDemo {
    public static void main(String[] args) {
        try {
            // Command to start a new process
            //ProcessBuilder is a Java class that lets you launch another process.
            //The arguments ("java", "ChildProgram") tell it:
            //Run the java command and execute the class ChildProgram.

            ProcessBuilder pb = new ProcessBuilder("java", "/Users/geek/Documents/Java/MultiThreading/src/Process/ChildProcessDemo.java");
            pb.inheritIO(); // So child process shares the same console output as of parent

            System.out.println("Parent PID: " + ProcessHandle.current().pid());
            Process process = pb.start(); // Start new process. It tells the operating system to actually start the new process you described in ProcessBuilder.

            System.out.println("Child Process created with PID: " + process.pid());

            // Wait for child process to finish
            int exitCode = process.waitFor();
            System.out.println("Child exited with code: " + exitCode);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}