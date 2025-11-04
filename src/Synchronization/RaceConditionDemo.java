package Synchronization;

class Account {
    int balance = 1000;

    void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is going to withdraw...");
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " found enough balance!");
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal.");
        } else {
            System.out.println("Not enough balance for " + Thread.currentThread().getName());
        }
        System.out.println("Current Balance:- " + balance);
    }
}

class RaceConditionDemo extends Thread {
    static Account account = new Account();

    public void run() {
        account.withdraw(800);
    }

    public static void main(String[] args) {
        RaceConditionDemo t1 = new RaceConditionDemo();
        RaceConditionDemo t2 = new RaceConditionDemo();

        t1.setName("Rohit");
        t2.setName("Deepika");

        t1.start();
        t2.start();
    }
}
