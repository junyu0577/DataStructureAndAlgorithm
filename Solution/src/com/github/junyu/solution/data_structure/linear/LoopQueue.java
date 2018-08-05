package com.github.junyu.solution.data_structure.linear;


public class LoopQueue<E> implements Queue<E> {


    private E data[];
    private int front;
    private int tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }

    private void resize(int capacity) {
        E newArr[] = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length];
        }
        front = 0;
        tail = size;
        data = newArr;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("queue is empty");

        E ret = data[front];
        size--;
        data[front] = null;
        front = (front + 1) % data.length;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    @Override
    public E getFirst() {
        if (isEmpty())
            throw new IllegalArgumentException("queue is empty");
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("LoopQueue:  capacity: " + getCapacity() + "\t size: " + size() + "\n");

        sb.append("[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)
                sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
}
