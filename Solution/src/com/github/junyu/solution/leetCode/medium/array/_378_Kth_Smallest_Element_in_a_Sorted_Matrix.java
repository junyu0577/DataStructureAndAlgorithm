package com.github.junyu.solution.leetCode.medium.array;

import com.github.junyu.solution.data_structure.heap.MaxHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {


    /*Given a n x n matrix where each of the rows and columns are sorted in ascending order,
    find the kth smallest element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    Example:

    matrix = [
            [ 1,  5,  9],
            [10, 11, 13],
            [12, 13, 15]
            ],
    k = 8,

            return 13.
    Note:
    You may assume k is always valid, 1 ≤ k ≤ n2.*/

//    /**
//     * 求矩阵中第k小的数
//     *  java提供的优先队列，具体实现方法和最大堆一样。
//     * @param matrix
//     * @param k
//     * @return
//     */
//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<Integer> q = new PriorityQueue((Comparator<Integer>) (o1, o2) -> o2-o1);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (q.size() < k)
//                    q.add(matrix[i][j]);
//                else {
//                    int largest = q.peek();
//                    if (largest > matrix[i][j]) {
//                        q.remove();
//                        q.add(matrix[i][j]);
//                    }
//                }
//            }
//        }
//        return q.peek();
//    }

    /**
     * 求矩阵中第k小的数
     * 使用最大堆求解，定义一个长度为k的最大堆。当堆中的元素数量少于k时，只管往堆中插入元素，堆的特性就是自动维护了第一个元素为
     * 堆中的最大值。当堆中元素达成k个数时，通过比较堆的第一个元素和当前的元素值，如果小于堆的第一个元素，那么就删除堆中的最大值，
     * 然后在插入当前这个元素。如此重复，直到遍历完矩阵，堆中的第一个元素就是第k小的数。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        MaxHeap maxHeap = new MaxHeap(k);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxHeap.size() < k)
                    maxHeap.insert(matrix[i][j]);
                else {
                    int largest = maxHeap.getMax();
                    if (largest > matrix[i][j]) {
                        maxHeap.remove();
                        maxHeap.insert(matrix[i][j]);
                    }
                }
            }
        }
        return maxHeap.getMax();
    }



    public static void main(String[] args) {
        int arr[][] = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

        System.out.println(new _378_Kth_Smallest_Element_in_a_Sorted_Matrix().kthSmallest(arr,8));
    }

}
