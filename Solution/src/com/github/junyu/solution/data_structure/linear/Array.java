package com.github.junyu.solution.data_structure.linear;

/**
 * @author ShaoJunyu
 * @since 2018/8/1 08:08
 */
public class Array<E> {

    private E data[];
    private int capacity;//数组长度
    private int size;//数组元素个数

    public Array(int size) {
        this.capacity = size;
        data = (E[]) new Object[capacity];
    }

    public Array() {
        this(10);
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 在数组的头部插入元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 往数组最后一个元素后面添加一个元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 往数组index位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("insert fail illegal index");

        if (capacity == size) {
            capacity *= 2;
            resize(capacity);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get fail illegal index");
        return data[index];
    }

    /**
     * 设置index位置的元素内容
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set fail illegal index");
        data[index] = e;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove fail illegal index");

        E e = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        if (size == capacity / 4 && capacity / 2 != 0) {
            capacity /= 2;
            resize(capacity);
        }

        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 查看数组中是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contain(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i]))
                return true;
        }
        return false;
    }

    /**
     * 查找直接元素的索引
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i]))
                return i;
        }
        return -1;
    }


    /**
     * 动态扩容或者缩容
     *
     * @param capacity
     */
    private void resize(int capacity) {
        E copyArr[] = (E[]) new Object[capacity];
        for (int i = 0; i < size(); i++) {
            copyArr[i] = data[i];
        }
        data = copyArr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("capacity: " + getCapacity() + "\t size: " + size() + "\n");

        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(data[i]);
            if (i != size() - 1)
                sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }

}
