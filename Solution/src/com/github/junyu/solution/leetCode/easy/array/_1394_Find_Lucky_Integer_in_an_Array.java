package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1394_Find_Lucky_Integer_in_an_Array {

   /* Given an array of integers arr, a lucky integer is an integer which has a frequency in the
    array equal to its value.

    Return a lucky integer in the array. If there are multiple lucky integers return the largest of them.
    If there is no lucky integer return -1.

    Example 1:

    Input: arr = [2,2,3,4]
    Output: 2
    Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
    Example 2:

    Input: arr = [1,2,2,3,3,3]
    Output: 3
    Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
    Example 3:

    Input: arr = [2,2,2,3,3]
    Output: -1
    Explanation: There are no lucky numbers in the array.
    Example 4:

    Input: arr = [5]
    Output: -1
    Example 5:

    Input: arr = [7,7,7,7,7,7,7]
    Output: 7


    Constraints:

    1 <= arr.length <= 500
    1 <= arr[i] <= 500*/

    /**
     * 解法二：不同于第一种解法，将数字出现的次数统计到int数组中，存放进map时有装箱和拆箱操作还会造成额外的时间成本。
     * @param arr
     * @return
     */
    public int findLucky(int[] arr) {
        int[] nums = new int[501];

        for (int i = 0; i < arr.length; i++) {
            nums[arr[i]] = ++nums[arr[i]];
        }

        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == i)
                max = Math.max(max, nums[i]);
        }

        return max;
    }


//    /**
//     * 找到幸运数字（数字的大小和出现的次数相等，如果有多个幸运数字，则选大的返回）
//     * 解题思路：先统计所有的数字出现的次数，并且把出现的数字都存在hashSet中，然后通过循环hashSet去判断幸运数字，如果是则将其与max值
//     * 做比较
//     * @param arr
//     * @return
//     */
//    public int findLucky(int[] arr) {
//        Set<Integer> nums = new HashSet<>();
//        Map<Integer, Integer> numCountMap = new HashMap<>();
//        for (int num : arr) {
//            nums.add(num);
//            numCountMap.merge(num, 1, Integer::sum);
//        }
//
//        int max = -1;
//        for (Integer num : nums) {
//            if (num == numCountMap.get(num))
//                max = Math.max(max, numCountMap.get(num));
//        }
//
//        return max;
//    }

    public static void main(String[] args) {
        _1394_Find_Lucky_Integer_in_an_Array test = new _1394_Find_Lucky_Integer_in_an_Array();
        System.out.println(test.findLucky(new int[]{2, 2, 3, 4}));
        System.out.println(test.findLucky(new int[]{1, 2, 2, 3, 3, 3}));
        System.out.println(test.findLucky(new int[]{2, 2, 2, 3, 3}));
        System.out.println(test.findLucky(new int[]{5}));
        System.out.println(test.findLucky(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

}
