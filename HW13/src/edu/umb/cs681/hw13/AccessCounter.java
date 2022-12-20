package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private HashMap<Path,Integer> mapHashMap = new HashMap<>();
    private ReentrantLock nonStaticLock = new ReentrantLock();
    private static ReentrantLock staticLock = new ReentrantLock();
    private static AccessCounter instance = null;
    private AccessCounter() {}

    public static AccessCounter getInstance() {
        staticLock.lock();
        try {
            if (instance == null)
                instance = new AccessCounter();
            return instance;
        }
        finally {
            staticLock.unlock();
        }
    }

    public void increment(Path path) {
        nonStaticLock.lock();
        mapHashMap.compute(path, (Path p, Integer i) -> {
            if(i == null) {
                return 1;
            } else {
                return i++;
            }
        });
        nonStaticLock.unlock();
    }

    public int getCount(Path path) {
        nonStaticLock.lock();
        int k = mapHashMap.compute(path, (Path p, Integer i) -> {
            if(i == null) {
                i = 0;
            }
            return i;
        });
        nonStaticLock.unlock();
        return k;
    }
}