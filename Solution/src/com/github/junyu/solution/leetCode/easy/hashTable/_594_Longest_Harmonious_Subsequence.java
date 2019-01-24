package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.HashMap;

public class _594_Longest_Harmonious_Subsequence {

   /* We define a harmonious array is an array where the difference
    between its maximum value and its minimum value is exactly 1.

    Now, given an integer array, you need to find the length of its
    longest harmonious subsequence among all its possible subsequences.

    Example 1:

    Input: [1,3,2,2,5,2,3,7]
    Output: 5
    Explanation: The longest harmonious subsequence is [3,2,2,2,3].
    Note: The length of the input array will not exceed 20,000.
    */

    /**
     * 找出最长的子数组符合最大值和最小值差值为1
     * 通过map去记录每个元素出现的次数，然后遍历map查看当前的元素是否存在相邻的元素，如果存在
     * 就进行两则的value值求和，同时和ans变量进行比较，后者大的话更新ans的值。
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                ans = Math.max(ans, map.get(key) + map.get(key + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _594_Longest_Harmonious_Subsequence longest_harmonious_subsequence = new _594_Longest_Harmonious_Subsequence();
        System.out.println(longest_harmonious_subsequence.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(longest_harmonious_subsequence.findLHS(new int[]{1, 1, 1, 2, 2, 2, 3}));
        System.out.println(longest_harmonious_subsequence.findLHS(new int[]{1, 1, 1, 1}));
    }
}
