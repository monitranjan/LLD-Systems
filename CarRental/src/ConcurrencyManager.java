import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyManager {
    private Map<String, ReentrantLock> locks = new ConcurrentHashMap<>();

    // Acquire a lock for a car
    public synchronized void acquireLock(String carId) {
        locks.putIfAbsent(carId, new ReentrantLock());
        locks.get(carId).lock();
    }

    // Release the lock for a car
    public synchronized void releaseLock(String carId) {
        if (locks.containsKey(carId)) {
            locks.get(carId).unlock();
        }
    }
}
