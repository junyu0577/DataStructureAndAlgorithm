package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores {

    /*
    Example 1:

    Input: nums = [90], k = 1
    Output: 0
    Explanation: There is one way to pick score(s) of one student:
            - [90]. The difference between the highest and
    lowest score is 90 - 90 = 0.

    The minimum possible difference is 0.
    Example 2:

    Input: nums = [9,4,1,7], k = 2
    Output: 2
    Explanation: There are six ways to pick score(s) of two students:
            - [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
            - [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
            - [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
            - [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
            - [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
            - [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
    The minimum possible difference is 2.


    Constraints:

            1 <= k <= nums.length <= 1000
            0 <= nums[i] <= 105
    */

    /**
     * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
     *
     * 由于是任意个学生，所以直接对数组进行排序，排序后通过遍历每次取数组中的k个元素，然后将这组元素的
     * 最右侧减去最左侧就得出这一组的差值，然后通过ans进行组与组之间的比较，取最小值。
     *
     * Runtime: 5 ms, faster than 83.47% of Java online submissions for Minimum Difference Between Highest and Lowest of K Scores.
     * Memory Usage: 44.2 MB, less than 73.78% of Java online submissions for Minimum Difference Between Highest and Lowest of K Scores.
     *
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        if (nums.length<2)
            return 0;

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<nums.length-k+1;i++){
            ans = Math.min(ans,nums[i+k-1]-nums[i]);
        }
        return ans;
    }


    public static void main(String [] args) {
        _1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores test = new _1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores();
        System.out.println(test.minimumDifference(new int[]{90},1));
        System.out.println(test.minimumDifference(new int[]{9,4,1,7},2));
        System.out.println(test.minimumDifference(new int[]{87063,61094,44530,21297,95857,93551,9918},6));
    }
}
