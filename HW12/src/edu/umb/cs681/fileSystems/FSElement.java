package edu.umb.cs681.fileSystems;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {

    protected ReentrantLock lock = new ReentrantLock();
    private String name;
    private int size;
    private static LocalDateTime creationTime;
    private Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime){
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        this.lock.lock();
        Directory parent = this.parent;
        this.lock.unlock();
        return parent;
    }

    public int getSize() {
        this.lock.lock();
        int size = this.size;
        this.lock.unlock();
        return size;
    }

    public LocalDateTime getCreationTime() {
        this.lock.lock();
        LocalDateTime time = this.creationTime;
        this.lock.unlock();
        return time;
    }

    public String getName() {
        this.lock.lock();
        String name = this.name;
        this.lock.unlock();
        return name;
    }

    public abstract boolean isDirectory();
}