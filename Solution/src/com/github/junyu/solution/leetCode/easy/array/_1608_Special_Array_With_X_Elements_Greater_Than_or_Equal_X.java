package com.github.junyu.solution.leetCode.easy.array;

public class _1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {

   /* You are given an array nums of non-negative integers. nums is considered special if there exists a number x
   such that there are exactly x numbers in nums that are greater than or equal to x.

    Notice that x does not have to be an element in nums.

    Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

    Example 1:

    Input: nums = [3,5]
    Output: 2
    Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
    Example 2:

    Input: nums = [0,0]
    Output: -1
    Explanation: No numbers fit the criteria for x.
    If x = 0, there should be 0 numbers >= x, but there are 2.
    If x = 1, there should be 1 number >= x, but there are 0.
    If x = 2, there should be 2 numbers >= x, but there are 0.
    x cannot be greater since there are only 2 numbers in nums.
            Example 3:

    Input: nums = [0,4,3,0,4]
    Output: 3
    Explanation: There are 3 values that are greater than or equal to 3.
    Example 4:

    Input: nums = [3,6,7,7,0]
    Output: -1


    Constraints:

            1 <= nums.length <= 100
            0 <= nums[i] <= 1000*/


    /**
     * 找出x，满足恰好有x个元素大于或等于x
     * 思路：根据题意如果存在x，则他的范围应该在[1-nums.length],因此就是从1-数组长度的范围查找符合的值。
     * 当count等于当前的i时，就意味着当前恰好有i个元素大于等于i。
     * @param nums
     * @return
     */
    public int specialArray(int[] nums) {
        for (int i=1;i<=nums.length;i++){
            int count = 0;
            for (int j=0;j<nums.length;j++){
                if (nums[j]>=i){
                    count++;
                }
            }
            if (count==i)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X test = new _1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X();
        System.out.println(test.specialArray(new int[]{3,5}));
        System.out.println(test.specialArray(new int[]{0,0}));
        System.out.println(test.specialArray(new int[]{0,4,3,0,4}));
        System.out.println(test.specialArray(new int[]{3,6,7,7,0}));
    }
}
