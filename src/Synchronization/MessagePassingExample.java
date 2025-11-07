// Shared resource (message box)
class Message {
    private String message;
    private boolean hasMessage = false;

    // Method to send a message
    public synchronized void send(String msg) {
        while (hasMessage) {
            try {
                wait(); // Wait until the previous message is received
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Send new message
        message = msg;
        hasMessage = true;
        System.out.println("Sent: " + msg);

        // Notify receiver
        notify();
    }

    // Method to receive a message
    public synchronized String receive() {
        while (!hasMessage) {
            try {
                wait(); // Wait until a new message is sent
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Read and clear message
        String msg = message;
        hasMessage = false;
        System.out.println("Received: " + msg);

        // Notify sender
        notify();
        return msg;
    }
}

// Sender Thread
class Sender extends Thread {
    private Message messageBox;

    Sender(Message box) {
        this.messageBox = box;
    }

    public void run() {
        String[] messages = {
                "Hi there!",
                "How are you?",
                "All good here.",
                "Let's meet tomorrow.",
                "bye"
        };

        for (String msg : messages) {
            messageBox.send(msg);
            try {
                Thread.sleep(800); // simulate delay between messages
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Receiver Thread
class Receiver extends Thread {
    private Message messageBox;

    Receiver(Message box) {
        this.messageBox = box;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            messageBox.receive();
            try {
                Thread.sleep(1000); // simulate reading time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class
public class MessagePassingExample {
    public static void main(String[] args) {
        Message box = new Message();

        Sender sender = new Sender(box);
        Receiver receiver = new Receiver(box);

        sender.start();
        receiver.start();
    }
}