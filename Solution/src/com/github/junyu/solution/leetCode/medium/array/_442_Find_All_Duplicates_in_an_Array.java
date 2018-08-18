package com.github.junyu.solution.leetCode.medium.array;

import java.util.ArrayList;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array {


    /*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
    some elements appear twice and others appear once.

    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?

    Example:
    Input:
            [4,3,2,7,8,2,3,1]

    Output:
            [2,3]
*/


    /**
     * 找出所有重复的数
     * 用hash表存储元素出现的次数
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int arr[] = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = ++arr[nums[i]];
        }

        for (int i=1;i<arr.length;i++){
            if (arr[i]==2)
                res.add(i);
        }

        return res;
    }

//    /**
//     * 先排序,再逐一比较,拿时间换空间
//     *
//     * @param nums
//     * @return
//     */
//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//
//        Arrays.sort(nums);
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1])
//                res.add(nums[i]);
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        _442_Find_All_Duplicates_in_an_Array find_all_duplicates_in_an_array = new _442_Find_All_Duplicates_in_an_Array();
        System.out.println(find_all_duplicates_in_an_array.findDuplicates(arr));
    }

}
