package com.github.junyu.solution.leetCode.easy.array;

public class _2176_Count_Equal_and_Divisible_Pairs_in_an_Array {

    /*
    Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.


    Example 1:

    Input: nums = [3,1,2,2,2,1,3], k = 2
    Output: 4
    Explanation:
    There are 4 pairs that meet all the requirements:
            - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
            - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
            - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
            - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
    Example 2:

    Input: nums = [1,2,3,4], k = 1
    Output: 0
    Explanation: Since no value in nums is repeated, there are no pairs (i,j) that meet all the requirements.


    Constraints:

            1 <= nums.length <= 100
            1 <= nums[i], k <= 100
    */


    /**
     * 统计数组中相等且可以被整除的数对
     *
     * 穷举所有存在的可能，每次比较两个元素是否相等，如果相等，是否对应的角标再相乘能够被k整除。条件都满足就累加ans。
     *
     * Runtime: 4 ms, faster than 89.18% of Java online submissions for Count Equal and Divisible Pairs in an Array.
     * Memory Usage: 43.6 MB, less than 32.10% of Java online submissions for Count Equal and Divisible Pairs in an Array.
     *
     * @param nums
     * @param k
     * @return
     */
    public int countPairs(int[] nums, int k) {
        int ans = 0;

        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j] && ((i*j)%k)==0){
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String [] args) {
        _2176_Count_Equal_and_Divisible_Pairs_in_an_Array test = new _2176_Count_Equal_and_Divisible_Pairs_in_an_Array();
        System.out.println(test.countPairs(new int[]{3,1,2,2,2,1,3},2));
        System.out.println(test.countPairs(new int[]{1,2,3,4},1));
    }
}
