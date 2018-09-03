package com.github.junyu.solution.leetCode.easy.array;

public class _724_Find_Pivot_Index {

  /*  Given an array of integers nums, write a method that returns the "pivot" index of this array.

    We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the
    sum of the numbers to the right of the index.

    If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

            Example 1:
    Input:
    nums = [1, 7, 3, 6, 5, 6]
    Output: 3
    Explanation:
    The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
    Also, 3 is the first index where this occurs.
            Example 2:
    Input:
    nums = [1, 2, 3]
    Output: -1
    Explanation:
    There is no index that satisfies the conditions in the problem statement.
    Note:

    The length of nums will be in the range [0, 10000].
    Each element nums[i] will be an integer in the range [-1000, 1000].*/

    /**
     * 寻找数组的中心索引，不存在则返回-1.
     * 中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 定义leftSum作为左半部分的sum，定一个rightSum作为右半部分的sum，leftSum初始值为0，rightSum为0-长度-1的总和。
     * 然后以第0个元素为起点，判断leftSum和rightSum是否相等，相等就返回索引，不等的话继续判断下一个index。
     * rightSum每次需要先排除当前的索引，而leftSum则在得到不等后，在加上当前的索引。
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        if (nums.length < 3)
            return -1;

        int leftSum = 0;
        int rightSum = getSum(nums);

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new _724_Find_Pivot_Index().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(new _724_Find_Pivot_Index().pivotIndex(new int[]{1, 2, 3}));
        System.out.println(new _724_Find_Pivot_Index().pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
        System.out.println(new _724_Find_Pivot_Index().pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }

}
