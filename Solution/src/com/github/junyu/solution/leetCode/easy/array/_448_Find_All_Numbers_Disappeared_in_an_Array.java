package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _448_Find_All_Numbers_Disappeared_in_an_Array {


/*
    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
    some elements appear twice and others appear once.

    Find all the elements of [1, n] inclusive that do not appear in this array.

    Could you do it without extra space and in O(n) runtime? You may assume the returned
    list does not count as extra space.

    Example:

    Input:
            [4,3,2,7,8,2,3,1]

    Output:
            [5,6]*/


    /**
     * 找出集合中所有缺失的数
     * 通过建立一个marker数组标记所有出现过的数，再遍历marker数组时，如果为false，当前的索引对应的值就没有出现
     * 由于0不在范围中，marker数组需要多开辟一个空间，在遍历marker数组时不考虑第0个元素。
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean marker[] = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                marker[nums[i]] = true;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i=1;i<marker.length;i++){
            if (!marker[i])
             res.add(i);
        }
        return  res;
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        _448_Find_All_Numbers_Disappeared_in_an_Array find_all_numbers_disappeared_in_an_array = new _448_Find_All_Numbers_Disappeared_in_an_Array();
        System.out.println(find_all_numbers_disappeared_in_an_array.findDisappearedNumbers(arr));
    }


}
