package Synchronization;
class Accountt {
    int balance = 1000;

    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw...");
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " found enough balance.");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal.");
        } else {
            System.out.println("Not enough balance for " + Thread.currentThread().getName());
        }
        System.out.println("Current Balance: " + balance);
    }
}

class RaceConditionSolutionDemo extends Thread {
    static Accountt account = new Accountt();

    public void run() {
        account.withdraw(800);
    }

    public static void main(String[] args) {
        RaceConditionSolutionDemo t1 = new RaceConditionSolutionDemo();
        RaceConditionSolutionDemo t2 = new RaceConditionSolutionDemo();

        t1.setName("Rohit");
        t2.setName("Deepika");

        t1.start();
        t2.start();
    }
}



