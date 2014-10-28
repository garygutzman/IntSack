package com.abc.ds.integer;

public interface IntDSSack {
    int count();
    boolean isEmpty();
    void clear();
    
    boolean add(int value);
    boolean remove(int value);
    boolean contains(int value);
    
    IntDSIterator createIterator();
}
