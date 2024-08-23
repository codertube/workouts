public class EvenOddDemo {
    int limit = 10;
    int count = 1;
    public void printEven() throws InterruptedException {
        synchronized (this) {
            while (count < limit) {
                while (count % 2 == 0) {
                    wait();
                }
                System.out.println(count);
                count ++;
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public void printOdd() throws InterruptedException {
        synchronized (this) {
            while (count < limit) {
                while (count % 2 != 0) {
                    wait();
                }
                System.out.println(count);
                count ++;
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public static void main(String[] args) {
        EvenOddDemo demo = new EvenOddDemo();
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
