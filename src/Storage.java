
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Storage {


    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = reentrantReadWriteLock.readLock();
    private final Lock writeLock = reentrantReadWriteLock.writeLock();

    private final Stack<Item> items;

    public Storage() {
        items = new Stack<>();
        for (int i = 1; i <= 250; i++) {
            items.push(new Item());
        }
    }

    public boolean isEmpty() {
        readLock.lock();
        var amount = this.items.isEmpty();
        readLock.unlock();
        return amount;
    }

    public Item getItem() {
        writeLock.lock();
        try {
            var item = items.pop();
            //Logger.INSTANCE.log("Removed item[" + item.getNumber() + "]");
            return item;
        } finally {
            writeLock.unlock();
        }
    }

}
