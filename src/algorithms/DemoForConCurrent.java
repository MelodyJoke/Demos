package algorithms;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * description Demo for concurrent
 * author Melo Chan
 * date 2017/9/18
 * version 0.0.0.1
 */
public class DemoForConCurrent {

    public static void main(String... args) {
        BlockingQueue<Product> queue = new ArrayBlockingQueue<>(1024);
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();
    }
}

class Product implements Delayed {

    private String name;

    Product(String name) {
        this.name = name;
    }

    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        return name.length() * 1000;
    }

    @Override
    public int compareTo(@NotNull Delayed o) {
        long difference = getDelay(TimeUnit.MICROSECONDS) - o.getDelay(TimeUnit.MICROSECONDS);
        return difference < 0 ? -1 : difference == 0 ? 0 : 1;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

class Producer implements Runnable {

    private BlockingQueue<Product> queue;

    private Scanner scanner;

    Producer(BlockingQueue<Product> queue) {
        this.queue = queue;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = scanner.nextLine();
                queue.put(new Product(line));
                if ("exit".equalsIgnoreCase(line)) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Product> queue;

    Consumer(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Product product = queue.take();
                System.out.println(product);
                if ("exit".equalsIgnoreCase(product.getName())) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}