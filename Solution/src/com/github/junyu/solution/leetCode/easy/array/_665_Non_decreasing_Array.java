package com.github.junyu.solution.leetCode.easy.array;

public class _665_Non_decreasing_Array {

  /*  Given an array with n integers, your task is to check if it could become
    non-decreasing by modifying at most 1 element.

    We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

    Example 1:
    Input: [4,2,3]
    Output: True
    Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
    Example 2:
    Input: [4,2,1]
    Output: False
    Explanation: You can't get a non-decreasing array by modify at most one element.
    Note: The n belongs to [1, 10,000].*/

    /**
     * 改变数组中的一个值，看是否能让数组变成非递减数列
     * 遍历数组，不断的与上一个进行比较，如果出现递减，那么进行一次修改。
     * 如果是在第一个1位置与0第一个位置发生的，那么就将第一个位置的元素赋值改第0个。
     * 如果是中间的某一个元素发生（排除最后一个元素），需要查看i位置的是否大于等于i-2,是则将i-2赋值给
     * i-1,否则就将i-1赋值给i。
     * 继续遍历数组，当第二次出现递减，那么就说明数组无法成为非递减数列
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3)
            return true;

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count == 1)
                    return false;

                if (i == 1)
                    nums[i - 1] = nums[i];
                else if (i < nums.length - 1) {
                    if (nums[i] >= nums[i - 2])
                        nums[i - 1] = nums[i - 2];
                    else if (nums[i] < nums[i - 2])
                        nums[i] = nums[i - 1];
                }
                count++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _665_Non_decreasing_Array().checkPossibility(new int[]{4, 2, 3}));
        System.out.println(new _665_Non_decreasing_Array().checkPossibility(new int[]{4, 2, 1}));
        System.out.println(new _665_Non_decreasing_Array().checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(new _665_Non_decreasing_Array().checkPossibility(new int[]{-1, 4, 2, 3}));
        System.out.println(new _665_Non_decreasing_Array().checkPossibility(new int[]{2, 3, 3, 2, 4}));
    }

}
