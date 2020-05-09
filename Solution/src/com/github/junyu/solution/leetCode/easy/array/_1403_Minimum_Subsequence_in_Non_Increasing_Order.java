package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1403_Minimum_Subsequence_in_Non_Increasing_Order {

    /*Given the array nums, obtain a subsequence of the array whose sum of elements is strictly
    greater than the sum of the non included elements in such subsequence.

    If there are multiple solutions, return the subsequence with minimum size and if there still
    exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an
    array can be obtained by erasing some (possibly zero) elements from the array.

    Note that the solution with the given constraints is guaranteed to be unique. Also return the
    answer sorted in non-increasing order.

    Example 1:

    Input: nums = [4,3,10,9,8]
    Output: [10,9]
    Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is
    strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum
    total sum of its elements.
    Example 2:

    Input: nums = [4,4,7,6,7]
    Output: [7,7,6]
    Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater
    than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal
    satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
    Example 3:

    Input: nums = [6]
    Output: [6]

    Constraints:

    1 <= nums.length <= 500
    1 <= nums[i] <= 100*/

    /**
     * 获取非递增顺序的最小子序列（这个子序列满足和大于剩余子序列的和，如果存在多个解决方案，只需返回 长度最小 的子序列。
     * 如果仍然有多个解决方案，则返回 元素之和最大 的子序列）
     * 解题思路：对数组先进行一次排序，然后统计数组元素的和，最后从大到小的顺序进行遍历求和并判断当前元素的和是否大于剩余的元素之和，
     * 一旦大于就已经获取到最小子序列了。
     *
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i=0;i<nums.length;i++)
            sum+=nums[i];
        List<Integer> ans = new ArrayList<>();
        int curSum = 0;
        for (int i=nums.length-1;i>=0;i--){
            curSum += nums[i];
            ans.add(nums[i]);
            if (curSum>sum-curSum){
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _1403_Minimum_Subsequence_in_Non_Increasing_Order test = new _1403_Minimum_Subsequence_in_Non_Increasing_Order();
        System.out.println(test.minSubsequence(new int[]{4,3,10,9,8}));
        System.out.println(test.minSubsequence(new int[]{4,4,7,6,7}));
        System.out.println(test.minSubsequence(new int[]{6}));
    }

}
