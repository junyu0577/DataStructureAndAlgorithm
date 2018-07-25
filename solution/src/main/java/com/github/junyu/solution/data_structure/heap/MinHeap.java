package com.github.junyu.solution.data_structure.heap;

import java.util.Arrays;

/**
 * 最小堆 第0个位置不存储元素
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/24 14:50
 */
public class MinHeap<T extends Comparable> {
    private T[] data;
    private int count;

    public MinHeap(int length) {
        data = (T[]) new Comparable[length + 1];
        count = 0;
    }

    /**
     * 数组建堆,通过shiftDown保证完全二叉的的特性
     *
     * @param arr
     * @param length
     */
    public MinHeap(T arr[], int length) {
        data = (T[]) new Comparable[length + 1];

        for (int i = 0; i < length; i++) {
            data[i + 1] = arr[i];
        }
        count = length;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 上移，保证完全二叉树的特征
     *
     * @param index
     */
    private void shiftUp(int index) {
        while (index > 1 && data[index / 2].compareTo(data[index]) > 0) {
            swap(data, index / 2, index);
            index = index / 2;
        }
    }


    /**
     * 下移，防止出现左右孩子小于父结点
     *
     * @param index
     */
    private void shiftDown(int index) {

        while (2 * index <= count) {//有左孩子的情况下
            int leftChild = 2 * index;
            if (leftChild + 1 <= count && data[leftChild + 1].compareTo(data[leftChild]) < 0) {//有右孩子并且值小于左孩子
                leftChild += 1;
            }
            if (data[index].compareTo(data[leftChild]) <= 0) {//小于左右子结点
                break;
            }
            swap(data, index, leftChild);
            index = leftChild;
        }
    }

    public void insert(T value) {
        if (count == data.length - 1) {
            throw new RuntimeException("heap is full");
        }
        data[count + 1] = value;
        count++;
        shiftUp(count);
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }

        T value = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);

        return value;

    }

    private void swap(T arr[], int left, int right) {
        T temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void printHeap() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        MinHeap maxHeap = new MinHeap(8);
        System.out.println("size: " + maxHeap.size() + " isEmpty:" + maxHeap.isEmpty());
        for (int i = 0; i < 8; i++) {
            maxHeap.insert((int) (Math.random() * 100));
        }
        maxHeap.printHeap();
        for (int i = 0; i < 8; i++) {
            System.out.println("remove:" + maxHeap.remove());
        }
    }
}
