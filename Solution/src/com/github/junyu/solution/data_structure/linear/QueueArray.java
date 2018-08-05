package com.github.junyu.solution.data_structure.linear;

public class QueueArray<E> implements Queue<E> {

    private Array<E> data;

    public QueueArray() {
        data = new Array();
    }

    public QueueArray(int capacity) {
        data = new Array(capacity);
    }

    @Override
    public void enQueue(E e) {
        data.addLast(e);
    }

    @Override
    public E deQueue() {
       return data.removeFirst();
    }

    @Override
    public E getFirst() {
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public int getCapacity() {
        return data.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Queue:  capacity: " + getCapacity() + "\t size: " + size() + "\n");

        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(data.get(i));
            if (i != size() - 1)
                sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
}
