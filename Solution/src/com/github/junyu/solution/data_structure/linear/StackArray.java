package com.github.junyu.solution.data_structure.linear;

/**
 * @author ShaoJunyu
 * @since 2018/8/1 09:33
 */
public class StackArray<E extends Comparable> implements Stack<E> {

    private Array<E> data;

    public StackArray() {
        data = new Array<>();
    }

    public StackArray(int capacity) {
        data = new Array(capacity);
    }


    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E top() {
        return data.get(data.size() - 1);
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

}
