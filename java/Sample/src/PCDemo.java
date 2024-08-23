import java.util.LinkedList;

class PC {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException {
        int count = 0;
        while (true) {
            synchronized (this) {
                while (list.size() == 1) {
                        wait();
                }
                System.out.println("Producer produced - "+ count);
                list.add(count++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.isEmpty()) {
                        wait();
                }
                int value = list.removeFirst();
                System.out.println("Consumer consumed - "+ value);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
public class PCDemo {
    public static void main(String[] args) {
        PC pc = new PC();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
