package edu.umb.cs681.hw15;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccessCounter {

    private ConcurrentHashMap<Path,Integer> mapHashMap = new ConcurrentHashMap<>();
    private ReentrantReadWriteLock nonStaticLock = new ReentrantReadWriteLock();
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
        nonStaticLock.writeLock().lock();
        mapHashMap.compute(path, (Path p, Integer i) -> {
            if(i == null) {
                return 1;
            } else {
                return i++;
            }
        });
        nonStaticLock.writeLock().unlock();
    }

    public int getCount(Path path) {
        nonStaticLock.readLock().lock();
        int k = mapHashMap.compute(path, (Path p, Integer i) -> {
            if(i == null) {
                i = 0;
            }
            return i;
        });
        nonStaticLock.readLock().unlock();
        return k;
    }
}