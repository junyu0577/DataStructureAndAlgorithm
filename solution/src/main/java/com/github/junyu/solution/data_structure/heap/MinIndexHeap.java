package com.github.junyu.solution.data_structure.heap;

import java.util.Arrays;

/**
 * 最小索引堆，通过增加索引数组，避免直接对数据进行交换操作
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018-06-24 20:32
 */
public class MinIndexHeap {
    private int[] data;
    private int count;
    private int[] indexes;

    public MinIndexHeap(int length) {
        data = new int[length + 1];
        indexes = new int[length + 1];
        count = 0;
    }

    /**
     * 数组建堆,通过shiftDown保证完全二叉的的特性
     *
     * @param arr
     * @param length
     */
    public MinIndexHeap(int arr[], int length) {
        data = new int[length + 1];
        indexes = new int[length + 1];
        for (int i = 0; i < length; i++) {
            data[i + 1] = arr[i];
            indexes[i + 1] = i + 1;
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
        while (index > 1 && data[indexes[index / 2]] > data[indexes[index]]) {
            swap(indexes, index / 2, index);
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
            if (leftChild + 1 <= count && data[indexes[leftChild + 1]] < data[indexes[leftChild]]) {//有右孩子并且值小于左孩子
                leftChild += 1;
            }
            if (data[indexes[index]] <= data[indexes[leftChild]]) {//小于左右子结点
                break;
            }
            swap(indexes, index, leftChild);
            index = leftChild;
        }
    }

    public void insert(int i, int value) {
        if (count == data.length - 1) {
            throw new RuntimeException("heap is full");
        }
        if (i + 1 < 1 || i + 1 > data.length - 1) {
            throw new RuntimeException(i + " is out of index");
        }
        i += 1;
        indexes[count + 1] = i;
        data[i] = value;
        count++;
        shiftUp(count);
    }

    /**
     * 删除最大值
     *
     * @return 返回被删除的值
     */
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }

        int value = data[indexes[1]];
        indexes[1] = indexes[count];
        count--;
        shiftDown(1);

        return value;

    }

    /**
     * 删除最大值
     *
     * @return 返回对应的索引
     */
    public int removeIndex() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }

        int index = indexes[1] - 1;
        indexes[1] = indexes[count];
        count--;
        shiftDown(1);

        return index;

    }

    /**
     * 获取索引为i的元素
     *
     * @param i
     * @return
     */
    public int getItem(int i) {
        return data[i + 1];
    }


    /**
     * 修改指定索引位置的元素
     */
    public void changeItem(int i, int value) {

        i += 1;
        data[i] = value;

        for (int j = 1; j <= count; i++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }

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
        int length = 8;
        MinIndexHeap minIndexHeap = new MinIndexHeap(length);
        for (int i = 0; i < 8; i++) {
            minIndexHeap.insert(i, (int) (Math.random() * 100));
        }
        minIndexHeap.printHeap();
        for (int i = 0; i < 8; i++) {
            System.out.println("remove:" + minIndexHeap.remove());
        }
    }

}
