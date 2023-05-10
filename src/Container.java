

import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Container {

    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = reentrantReadWriteLock.readLock();
    private final Lock writeLock = reentrantReadWriteLock.writeLock();
    private final Stack<Item> items = new Stack<>();


    public Stack<Item> getItems() {
        readLock.lock();
        Stack<Item> itemsCopy = items;
        readLock.unlock();

        return itemsCopy;
    }

    public boolean isFull() {
        readLock.lock();
        var full = this.items.size() == 25;
        readLock.unlock();

        return full;
    }

    public void insertItem(Item item) {
        writeLock.lock();
        try {
            if (!isFull()) {
                items.push(item);
            }
            if (items.size() == 25) {
                System.out.println("Container is full");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }
}
