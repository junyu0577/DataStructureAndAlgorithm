package com.github.junyu.solution.leetCode.easy.array;

public class _1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away {

   /*
    Given an array nums of 0s and 1s and an integer k, return True if all
    1's are at least k places away from each other, otherwise return False.
    Example 1:

    Input: nums = [1,0,0,0,1,0,0,1], k = 2
    Output: true
    Explanation: Each of the 1s are at least 2 places away from each other.
            Example 2:

    Input: nums = [1,0,0,1,0,1], k = 2
    Output: false
    Explanation: The second 1 and third 1 are only one apart from each other.
            Example 3:

    Input: nums = [1,1,1,1,1], k = 0
    Output: true
    Example 4:

    Input: nums = [0,1,0,1], k = 1
    Output: true

    Constraints:

    1 <= nums.length <= 10^5
    0 <= k <= nums.length
    nums[i] is 0 or 1
    */


    public static void main(String[] args) {
        _1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away test =
                new _1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away();
        System.out.println(test.kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(test.kLengthApart(new int[]{1,0,0,1,0,1}, 2));
        System.out.println(test.kLengthApart(new int[]{1,1,1,1,1}, 0));
        System.out.println(test.kLengthApart(new int[]{0,1,0,1}, 1));
    }

    /**
     * 检查数组中所有1之间的最小间隔是否小于等于给定的k
     * 解题思路就是首先找出第一个1，然后通过遍历1后面整个数组，在遍历的同时，判断当前的元素是1还是0，如果是0，那么递增当前记录的距离（curDistance），
     * 如果是1，判断是否上一个元素是否也是1，整个可以通过curDistance==0为条件进行判断，如果也是1，那么整个数组最短距离就是0，则可以直接结束循环。
     * 如果是0，则更新最短距离的值，保留更短距离的值，并且还原curDistance为0.
     *
     * 最后如果最小距离的值小于等于给定的k，那么就满足条件
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean kLengthApart(int[] nums, int k) {
        int point = 0;
        int curDistance = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                point = i + 1;
                break;
            }
        }

        while (point < nums.length) {
            if (nums[point] == 1) {
                if (curDistance == 0) {
                    minDistance = 0;
                    break;
                } else {
                    minDistance = Math.min(minDistance, curDistance);
                    curDistance = 0;
                }
            } else {
                curDistance++;
            }
            point++;
        }
        return k <= minDistance;
    }
}
