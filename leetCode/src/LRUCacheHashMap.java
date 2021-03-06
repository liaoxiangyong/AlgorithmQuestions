import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LXY on 2018/3/3.
 */
public class LRUCacheHashMap<K,V> extends LinkedHashMap<K,V>{

    private final int maxCapacity;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private final Lock lock = new ReentrantLock();

    public LRUCacheHashMap(int maxCapacity){
        super(maxCapacity,DEFAULT_LOAD_FACTOR,true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldestEntry){
        return size() > maxCapacity;
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return super.containsKey(key);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }
}
