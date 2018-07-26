package com.github.junyu.solution.data_structure.heap;

import java.util.Arrays;

/**
 * 最小索引堆，通过增加索引数组，避免直接对数据进行交换操作
 * 新增的reverse数组提升了change时的效率，将查找的时间复杂度从o(n)优化到o(1)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018-06-24 20:32
 */
public class MinIndexHeap2<T extends Comparable> {
    private T[] data;
    private int count;
    private int[] indexes;
    private int[] reverse;

    public MinIndexHeap2(int length) {
        data = (T[]) new Comparable[length + 1];
        indexes = new int[length + 1];
        reverse = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            reverse[i] = 0;
        }
        count = 0;
    }

    /**
     * 数组建堆,通过shiftDown保证完全二叉的的特性
     *
     * @param arr
     * @param length
     */
    public MinIndexHeap2(T arr[], int length) {
        data = (T[]) new Comparable[length + 1];
        indexes = new int[length + 1];
        reverse = new int[length + 1];
        for (int i = 0; i < length; i++) {
            data[i + 1] = arr[i];
            indexes[i + 1] = i + 1;
            reverse[i] = 0;
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
        while (index > 1 && data[indexes[index / 2]].compareTo(data[indexes[index]]) > 0) {
            swap(indexes, index / 2, index);
            reverse[indexes[index / 2]] = index / 2;
            reverse[indexes[index]] = index;
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
            if (leftChild + 1 <= count && data[indexes[leftChild + 1]].compareTo(data[indexes[leftChild]])<0) {//有右孩子并且值小于左孩子
                leftChild += 1;
            }
            if (data[indexes[index]].compareTo(data[indexes[leftChild]]) <= 0) {//小于左右子结点
                break;
            }
            swap(indexes, index, leftChild);
            reverse[indexes[index]] = index;
            reverse[indexes[leftChild]] = leftChild;
            index = leftChild;
        }
    }

    public void insert(int i, T value) {
        if (count == data.length - 1) {
            throw new RuntimeException("heap is full");
        }
        if (i + 1 < 1 || i + 1 > data.length - 1) {
            throw new RuntimeException(i + " is out of index");
        }
        i += 1;
        data[i] = value;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    /**
     * 删除最大值
     *
     * @return 返回被删除的值
     */
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }

        T value = data[indexes[1]];
        indexes[1] = indexes[count];
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
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
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
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
    public T getItem(int i) {
        if (!contain(i)) {
            throw new RuntimeException(i + "is not in heap");
        }
        return data[i + 1];
    }

    private boolean contain(int i) {
        if (i + 1 < 1 || i + 1 > data.length - 1) {
            throw new RuntimeException(i + " is out of index");
        }
        return reverse[i + 1] != 0;
    }

    /**
     * 修改指定索引位置的元素
     */
    public void changeItem(int i, T value) {
        if (!contain(i)) {
            throw new RuntimeException(i + "is not in heap");
        }

        i += 1;
        data[i] = value;

        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
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
        int length = 7;
//        MinIndexHeap2 minIndexHeap2 = new MinIndexHeap2(length);
//        for (int i = 0; i < length; i++) {
//            minIndexHeap2.insert(i, (int) (Math.random() * 100));
//        }
//        for (int i = 0; i < length; i++) {
//            System.out.print(minIndexHeap2.remove() + " ");
//        }

        Comparable  [] arr = generateRandomArr(length,0,100);
        System.out.println(Arrays.toString(arr));
        MinIndexHeap2 minIndexHeap2 = new MinIndexHeap2(arr,length);
        for (int i=0;i<length;i++){
            System.out.print(minIndexHeap2.remove()+" ");
        }

    }

    private static Comparable[] generateRandomArr(int n, int min, int max) {

        Comparable[] arr = new Comparable[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        return arr;
    }
}
