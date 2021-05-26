package com.github.junyu.solution.leetCode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1630_Arithmetic_Subarrays {

    /*
    A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive
    elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.

    For example, these are arithmetic sequences:

            1, 3, 5, 7, 9
            7, 7, 7, 7
            3, -1, -5, -9
    The following sequence is not arithmetic:

            1, 1, 2, 5, 7
    You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries,
     where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

    Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]]
     can be rearranged to form an arithmetic sequence, and false otherwise.

    Example 1:

    Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
    Output: [true,false,true]
    Explanation:
    In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
    In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
    In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.
            Example 2:

    Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
    Output: [false,true,false,false,true,true]


    Constraints:

    n == nums.length
    m == l.length
    m == r.length
    2 <= n <= 500
    1 <= m <= 500
    0 <= l[i] < r[i] < n
    -Math.pow(10,5) <= nums[i] <= Math.pow(10,5)*/

    /**
     * 等差子数组
     * 从nums数组中基于l与r中的元素copy中子数组，并对子数组进行排序。
     * 然后比较相邻元素之间的差值是否相等。
     *
     * Runtime: 15 ms, faster than 75.35% of Java online submissions for Arithmetic Subarrays.
     * Memory Usage: 39.7 MB, less than 40.78% of Java online submissions for Arithmetic Subarrays.
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i=0;i<l.length;i++){
            boolean res = true;
            int start = l[i];
            int end = r[i];
            int [] arr = Arrays.copyOfRange(nums,start,end+1);
            Arrays.sort(arr);
            int diff = arr[0]-arr[1];
            for (int j=1;j<arr.length-1;j++){
                if (arr[j]-arr[j+1]!=diff){
                    res = false;
                    break;
                }
            }
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        _1630_Arithmetic_Subarrays test = new _1630_Arithmetic_Subarrays();
        System.out.println(test.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7},new int[]{0,0,2},new int[]{2,3,5}));
        System.out.println(test.checkArithmeticSubarrays(new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10},new int[]{0,1,6,4,8,7},new int[]{4,4,9,7,9,10}));
    }
}
