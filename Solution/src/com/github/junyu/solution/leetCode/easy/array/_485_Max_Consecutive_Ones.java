package com.github.junyu.solution.leetCode.easy.array;

public class _485_Max_Consecutive_Ones {

  /*  Given a binary array, find the maximum number of consecutive 1s in this array.

            Example 1:
    Input: [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
    Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000*/


    /**
     * 求最长连续的1的个数
     * 定义两个变量count记录最长连续1的个数，tempCount为当前连续个数，
     * 遍历数组，当元素为1的时候，tempCount++，如果不是1，那么就应该看看tempCount中的值是否大于count，大于则
     * 更新count的值，然后tempCount复位从0开始。如果最后一个元素为1，是不会进行else的逻辑，那么在最后仍然要查看
     * tempCount的值是否大于count。
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int count = 0;
        int tempCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempCount++;
            } else {
                count = Math.max(count, tempCount);
                tempCount = 0;
            }
        }
        return Math.max(count, tempCount);
    }

    public static void main(String[] args) {
        int arr [] = {1,1,0,1,1,1};
//        int arr [] = {0};
        _485_Max_Consecutive_Ones max_consecutive_ones = new _485_Max_Consecutive_Ones();
        System.out.println(max_consecutive_ones.findMaxConsecutiveOnes(arr));
    }

}
