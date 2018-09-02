package com.github.junyu.solution.leetCode.easy.array;

import java.util.PriorityQueue;

public class _703_Kth_Largest_Element_in_a_Stream {

 /*   Design a class to find the kth largest element in a stream. Note that
    it is the kth largest element in the sorted order, not the kth distinct element.

    Your KthLargest class will have a constructor which accepts an integer k
        and an integer array nums, which contains initial elements from the stream.
    For each call to the method KthLargest.add, return the element representing
    the kth largest element in the stream.

    Example:

    int k = 3;
    int[] arr = [4,5,8,2];
    KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
    Note:
    You may assume that nums' length ≥ k-1 and k ≥ 1.*/

    private PriorityQueue<Integer> q;
    private int size;

    /**
     * 数据流中第k大的元素，这题也是一个堆相关的问题，在队列中不断的新增元素，还要获取第k大的元素，很显然
     * 可以使用最小堆去做。堆的大小为k，第一个元素是最小的，当有新的元素到来时，和最小的元素进行比较，如果大于第一个元素，
     * 那么删除堆中的第一个元素，然后再插入这个新元素，而堆中一直保存整个数据流中最大的那一批。
     *
     * @param k
     * @param nums
     */
    public _703_Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        q = new PriorityQueue<>();
        size = k;

        for (int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (q.size() < size) {
            q.add(val);
        } else if (q.peek() < val) {
            q.poll();
            q.add(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        _703_Kth_Largest_Element_in_a_Stream kthLargest = new _703_Kth_Largest_Element_in_a_Stream(k, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
