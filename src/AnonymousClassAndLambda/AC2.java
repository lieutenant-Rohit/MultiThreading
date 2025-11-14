package AnonymousClassAndLambda;



public class AC2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run()
            {
                System.out.println("Thread is Running");
            }
        };
        t.start();
    }
}
