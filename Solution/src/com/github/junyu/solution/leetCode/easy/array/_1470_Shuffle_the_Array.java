package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1470_Shuffle_the_Array {

    /*Given the array nums consisting of 2n elements in
    the form [x1,x2,...,xn,y1,y2,...,yn].

    Return the array in the form [x1,y1,x2,y2,...,xn,yn].

    Example 1:

    Input: nums = [2,5,1,3,4,7], n = 3
    Output: [2,3,5,4,1,7]
    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
    Example 2:

    Input: nums = [1,2,3,4,4,3,2,1], n = 4
    Output: [1,4,2,3,3,2,4,1]
    Example 3:

    Input: nums = [1,1,2,2], n = 2
    Output: [1,2,1,2]


    Constraints:

            1 <= n <= 500
    nums.length == 2n
    1 <= nums[i] <= 10^3
    */

    /**
     * 重新排列数组
     * 思路：循环n（nums.length/2）次，从第一以及中间位开始分别向后取元素，
     * 每次取两个插入到结果数组。
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int [] ans = new int[nums.length];
        int index = 0;
        for (int i=0;i<n;i++){
            ans[index++] = nums[i];
            ans[index++] = nums[n+i];
        }
        return ans;
    }

    public static void main(String [] args) {
        _1470_Shuffle_the_Array test = new _1470_Shuffle_the_Array();
        System.out.println(Arrays.toString(test.shuffle(new int[]{2,5,1,3,4,7},3)));
        System.out.println(Arrays.toString(test.shuffle(new int[]{1,2,3,4,4,3,2,1},4)));
        System.out.println(Arrays.toString(test.shuffle(new int[]{1,1,2,2},2)));
    }
}
