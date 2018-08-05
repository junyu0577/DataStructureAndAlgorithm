package com.github.junyu.solution.data_structure.linear;

public interface Queue<E> {

    void enQueue(E e);

    E deQueue();

    E getFirst();

    boolean isEmpty();

    int size();

    int getCapacity();
}
