package com.github.junyu.solution.data_structure.heap;

import java.util.Arrays;

/**
 * 最大堆 第0个位置不存储元素
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/24 14:50
 */
public class MaxHeap {
    private int[] data;
    private int count;

    public MaxHeap(int length) {
        data = new int[length + 1];
        count = 0;
    }

    /**
     * 数组建堆,通过shiftDown保证完全二叉的的特性
     *
     * @param arr
     * @param length
     */
    public MaxHeap(int arr[], int length) {
        data = new int[length + 1];

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
        while (index > 1 && data[index / 2] < data[index]) {
            swap(data, index / 2, index);
            index = index / 2;
        }
    }


    /**
     * 下移，防止出现左右孩子大于父结点
     *
     * @param index
     */
    private void shiftDown(int index) {

        while (2 * index <= count) {//有左孩子的情况下
            int leftChild = 2 * index;
            if (leftChild + 1 <= count && data[leftChild + 1] > data[leftChild]) {//有右孩子并且值大于左孩子
                leftChild += 1;
            }
            if (data[index] >= data[leftChild]) {//大于左右子结点
                break;
            }
            swap(data, index, leftChild);
            index = leftChild;
        }
    }

    public void insert(int value) {
        if (count == data.length - 1) {
            throw new RuntimeException("heap is full");
        }
        data[count + 1] = value;
        count++;
        shiftUp(count);
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }

        int value = data[1];
        data[1] = data[count];
        shiftDown(1);
        count--;

        return value;

    }

    private void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void printHeap() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
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
