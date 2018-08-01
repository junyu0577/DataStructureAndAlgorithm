package com.github.junyu.solution.leetCode.easy.design;


import java.util.Arrays;
import java.util.Random;

/**
 * @author ShaoJunyu
 * @since 2018/8/1 12:33
 */
public class _384_Shuffle_an_Array {


  /*  Shuffle a set of numbers without duplicates.

            Example:

    // Init an array with set 1, 2, and 3.
    int[] nums = {1,2,3};
    Solution solution = new Solution(nums);

    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
    solution.shuffle();

    // Resets the array back to its original configuration [1,2,3].
    solution.reset();

    // Returns the random shuffling of array [1,2,3].
    solution.shuffle();*/

//    class ListNode {
//        int left, right;
//        ListNode next;
//
//        ListNode(int left, int right) {
//            this.left = left;
//            this.right = right;
//        }
//    }

    private int[] nums;
    private Random random;

    /**
     * Shuffle洗牌算法
     * 每次洗牌都进行n-1次循环，从尾部依次向前，使得元素可交换的范围变小。
     *
     * @param nums
     */
    public _384_Shuffle_an_Array(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = arr.length - 1; i > 0; i--) {
            int other = random.nextInt(i+1);
            swap(i, other, arr);
        }

        return arr;
    }

    private void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        _384_Shuffle_an_Array shuffle_an_array = new _384_Shuffle_an_Array(arr);
        for (int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(shuffle_an_array.shuffle()));
        }
        System.out.println(Arrays.toString(shuffle_an_array.reset()));
    }

}
