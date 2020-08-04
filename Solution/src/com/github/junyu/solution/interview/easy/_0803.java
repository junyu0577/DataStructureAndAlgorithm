package com.github.junyu.solution.interview.easy;

public class _0803 {

   /* 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，
    在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

    示例1:

    输入：nums = [0, 2, 3, 4, 5]
    输出：0
    说明: 0下标的元素为0
    示例2:

    输入：nums = [1, 1, 1]
    输出：1
    提示:

    nums长度在[1, 1000000]之间*/

    /**
     * 魔术索引 索引和元素的值相等
     * 思路：遍历数组判断索引和值相等即返回索引。
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _0803 test = new _0803();
        System.out.println(test.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(test.findMagicIndex(new int[]{1, 1, 1}));
    }
}
