package Synchronization;

// ProducerConsumerExample.java
class SharedResource {
    private int data;
    private boolean available = false;

    // Producer method
    public synchronized void produce(int value) {
        while (available) {  // if data already produced, wait
            try {
                wait(); // release lock, go into waiting state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Produce the data
        data = value;
        System.out.println("Produced: " + value);
        available = true;

        // Notify consumer that new data is available
        notify();
    }

    // Consumer method
    public synchronized void consume() {
        while (!available) {  // if no data, wait
            try {
                wait(); // release lock, go into waiting state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Consume the data
        System.out.println("Consumed: " + data);
        available = false;

        // Notify producer that data has been consumed
        notify();
    }
}

// Producer thread
class Producer extends Thread {
    private SharedResource resource;

    Producer(SharedResource r) {
        this.resource = r;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);
            try {
                Thread.sleep(500); // simulate production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer thread
class Consumer extends Thread {
    private SharedResource resource;

    Consumer(SharedResource r) {
        this.resource = r;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();
            try {
                Thread.sleep(1000); // simulate slower consumption
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class
public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();

        Producer p = new Producer(shared);
        Consumer c = new Consumer(shared);

        p.start();
        c.start();
    }
}