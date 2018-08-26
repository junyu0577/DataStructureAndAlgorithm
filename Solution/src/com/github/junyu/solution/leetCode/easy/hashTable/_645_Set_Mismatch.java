package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.Arrays;

public class _645_Set_Mismatch {


    /*The set S originally contains numbers from 1 to n. But unfortunately,
    due to the data error, one of the numbers in the set got duplicated to another
    number in the set, which results in repetition of one number and loss of another number.

    Given an array nums representing the data status of this set after the error.
    Your task is to firstly find the number occurs twice and then find the number that
    is missing. Return them in the form of an array.

    Example 1:
    Input: nums = [1,2,2,4]
    Output: [2,3]
    Note:
    The given array size will in the range [2, 10000].
    The given array's numbers won't have any order.*/

    /**
     * 找出数组中重复的数和缺失的数
     * 天然的hash表题，建立一个长度为数组长度+1的hash表，保存所有数字出现的字数，
     * 最后遍历hash表时为0的就是缺失的数，为2的就是重复的数
     * 由于数组中不含0，那么第0个位置就忽略
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int arr[] = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int missNum = 0;
        int repeatNum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                missNum = i;
            else if (arr[i] == 2)
                repeatNum = i;
        }
        return new int[]{repeatNum, missNum};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _645_Set_Mismatch().findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(new _645_Set_Mismatch().findErrorNums(new int[]{37,62,43,27,12,66,36,18,39,54,61,65,47,32,23,2,46,8,4,24,29,38,63,39,25,11,45,28,44,52,15,30,21,7,57,49,1,59,58,14,9,40,3,42,56,31,20,41,22,50,13,33,6,10,16,64,53,51,19,17,48,26,34,60,35,5})));
    }

}

