package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.HashSet;
import java.util.Set;

public class _2154_Keep_Multiplying_Found_Values_by_Two {


    /*
    You are given an array of integers nums. You are also given an integer original
    which is the first number that needs to be searched for in nums.

    You then do the following steps:

    If original is found in nums, multiply it by two (i.e., set original = 2 * original).
    Otherwise, stop the process.
            Repeat this process with the new number as long as you keep finding the number.
    Return the final value of original.



    Example 1:

    Input: nums = [5,3,6,1,12], original = 3
    Output: 24
    Explanation:
            - 3 is found in nums. 3 is multiplied by 2 to obtain 6.
            - 6 is found in nums. 6 is multiplied by 2 to obtain 12.
            - 12 is found in nums. 12 is multiplied by 2 to obtain 24.
            - 24 is not found in nums. Thus, 24 is returned.
    Example 2:

    Input: nums = [2,7,9], original = 4
    Output: 4
    Explanation:
            - 4 is not found in nums. Thus, 4 is returned.


    Constraints:

            1 <= nums.length <= 1000
            1 <= nums[i], original <= 1000

    */


    /**
     *
     * 将找到的值乘以 2
     *
     * 将所有的元素存放到哈希表，然后通过判断包含关系去更新original，如果存在就不断乘以2，不存在则返回original。
     *
     * Runtime: 5 ms, faster than 46.18% of Java online submissions for Keep Multiplying Found Values by Two.
     * Memory Usage: 45.8 MB, less than 25.75% of Java online submissions for Keep Multiplying Found Values by Two.
     *
     * @param nums
     * @param original
     * @return
     */
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

    public static void main(String[] args) {
        _2154_Keep_Multiplying_Found_Values_by_Two test = new _2154_Keep_Multiplying_Found_Values_by_Two();
        System.out.println(test.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        System.out.println(test.findFinalValue(new int[]{2, 7, 9}, 4));
    }
}
