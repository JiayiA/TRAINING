class HelloWorld{


public static class Task implements Runnable {
    private int max;
    private Printer print;
    private boolean isNumber;

    public Task(Printer print, int max, boolean isNumber){
        this.print = print;
        this.max = max;
        this.isNumber = isNumber;
    }
    @Override
    public void run() {
        int number = 1;
        char letter = 'a';
        while (number <= max) {
            if (isNumber) {
                print.printNumber(number);
            } else {
                print.printLetter((char)letter);
            }
            number += 1;
            letter += 1;
        }
    }
}

public static class Printer {
    private volatile boolean isNumber;

    synchronized void printNumber(int number) {
        while (isNumber) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isNumber = true;
        notify();
    }

    synchronized void printLetter(char number) {
        while (!isNumber) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isNumber = false;
        notify();
    }
}

public static void main(String[] args) {
    Printer print = new Printer();
    Thread t1 = new Thread(new Task(print, 26, true),"Number");
    Thread t2 = new Thread(new Task(print, 26, false),"Letter");
    t1.start();
    t2.start();
}
}
