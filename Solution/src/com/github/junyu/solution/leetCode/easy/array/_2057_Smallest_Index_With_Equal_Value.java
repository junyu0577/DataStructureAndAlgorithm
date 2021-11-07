package com.github.junyu.solution.leetCode.easy.array;

public class _2057_Smallest_Index_With_Equal_Value {

    /*
    Given a 0-indexed integer array nums, return the smallest index i of
    nums such that i mod 10 == nums[i], or -1 if such index does not exist.

    x mod y denotes the remainder when x is divided by y.



    Example 1:

    Input: nums = [0,1,2]
    Output: 0
    Explanation:
    i=0: 0 mod 10 = 0 == nums[0].
    i=1: 1 mod 10 = 1 == nums[1].
    i=2: 2 mod 10 = 2 == nums[2].
    All indices have i mod 10 == nums[i], so we return the smallest index 0.


    Example 2:

    Input: nums = [4,3,2,1]
    Output: 2
    Explanation:
    i=0: 0 mod 10 = 0 != nums[0].
    i=1: 1 mod 10 = 1 != nums[1].
    i=2: 2 mod 10 = 2 == nums[2].
    i=3: 3 mod 10 = 3 != nums[3].
    2 is the only index which has i mod 10 == nums[i].


    Example 3:

    Input: nums = [1,2,3,4,5,6,7,8,9,0]
    Output: -1
    Explanation: No index satisfies i mod 10 == nums[i].


    Example 4:

    Input: nums = [2,1,3,5,2]
    Output: 1
    Explanation: 1 is the only index with i mod 10 == nums[i].


    Constraints:

            1 <= nums.length <= 100
            0 <= nums[i] <= 9

    */


    /**
     * 值相等的最小索引
     * 当遍历到的元素等于（当前索引 mod 10 ）则返回索引，否则返回-1。
     *
     * Runtime: 1 ms, faster than 68.32% of Java online submissions for Smallest Index With Equal Value.
     * Memory Usage: 39.3 MB, less than 71.51% of Java online submissions for Smallest Index With Equal Value.
     * @param nums
     * @return
     */
    public int smallestEqual(int[] nums) {
        int ans = -1;
        for (int i=0;i<nums.length;i++){
            if (i%10 == nums[i])
                return i;
        }
        return ans;
    }

    public static void main(String [] args) {
        _2057_Smallest_Index_With_Equal_Value test = new _2057_Smallest_Index_With_Equal_Value();
        System.out.println(test.smallestEqual(new int[]{0,1,2}));
        System.out.println(test.smallestEqual(new int[]{4,3,2,1}));
        System.out.println(test.smallestEqual(new int[]{1,2,3,4,5,6,7,8,9,0}));
        System.out.println(test.smallestEqual(new int[]{2,1,3,5,2}));
    }
}
