package Synchronization;

class Printer {
    boolean isOddTurn = true;

    synchronized void printOdd(int number) {
        while (!isOddTurn) {
            try {
                wait(); // Wait until it's odd's turn
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // ✅ Now it's odd's turn
        System.out.println("Odd Number: " + number);
        isOddTurn = false;  // Next turn is even
        notify();           // Wake up even thread
    }

    synchronized void printEven(int number) {
        while (isOddTurn) {
            try {
                wait(); // Wait until it's even's turn
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // ✅ Now it's even's turn
        System.out.println("Even Number: " + number);
        isOddTurn = true;   // Next turn is odd
        notify();           // Wake up odd thread
    }
}

public class OddEven {
    public static void main(String[] args) {
        Printer p = new Printer();

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                p.printOdd(i);
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                p.printEven(i);
            }
        });

        oddThread.start();
        evenThread.start();
    }
}