package MultiThreadingJava;

public class OddAndEvenNumbers {
    private int number = 1;
    private final int max;
    private final Object lock = new Object();

    public OddAndEvenNumbers(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (lock) {
            while (number <= max) {
                while (number % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= max) {
                    System.out.println("Odd:" + number++);
                    lock.notify();
                }
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (number <= max) {
                while (number % 2 == 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= max) {
                    System.out.println("Even:" + number++);
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        OddAndEvenNumbers printer = new OddAndEvenNumbers(10);
        Thread oddThread = new OddThread(printer);
        Thread evenThread = new EvenThread(printer);
        oddThread.start();
        evenThread.start();
    }
}

class OddThread extends Thread {
    private final OddAndEvenNumbers printer;

    public OddThread(OddAndEvenNumbers printer) {
        this.printer = printer;
    }

    public void run() {
        printer.printOdd();
    }
}

class EvenThread extends Thread {
    private final OddAndEvenNumbers printer;

    public EvenThread(OddAndEvenNumbers printer) {
        this.printer = printer;
    }

    public void run() {
        printer.printEven();
    }
}

