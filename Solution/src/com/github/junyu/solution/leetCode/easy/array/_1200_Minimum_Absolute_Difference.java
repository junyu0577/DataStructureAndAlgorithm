package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1200_Minimum_Absolute_Difference {


   /* Given an array of distinct integers arr, find all pairs of elements with the
    minimum absolute difference of any two elements.

    Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

    a, b are from arr
    a < b
    b - a equals to the minimum absolute difference of any two elements in arr


    Example 1:

    Input: arr = [4,2,1,3]
    Output: [[1,2],[2,3],[3,4]]
    Explanation: The minimum absolute difference is 1. List all pairs with difference
    equal to 1 in ascending order.
            Example 2:

    Input: arr = [1,3,6,10,15]
    Output: [[1,3]]
    Example 3:

    Input: arr = [3,8,-10,23,19,-4,-14,27]
    Output: [[-14,-10],[19,23],[23,27]]


    Constraints:

            2 <= arr.length <= 10^5
            -10^6 <= arr[i] <= 10^6*/

    /**
     * 差值最小的配对子集合
     * 思路：先对数组进行排序，然后进行两两比较，如果发现比上一个差值要小的，就清空ans集合，再插入新的配对子集合。
     * 如果刚好和上一个差值相等，就插入子集合。
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pairs = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int curDiff = arr[i + 1] - arr[i];
            if (curDiff > diff)
                continue;

            if (curDiff< diff) {
                ans.clear();
            }
            pairs = new ArrayList<>();
            pairs.add(arr[i]);
            pairs.add(arr[i + 1]);
            ans.add(pairs);

            diff = curDiff;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1200_Minimum_Absolute_Difference test = new _1200_Minimum_Absolute_Difference();
        System.out.println(test.minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(test.minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(test.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
        System.out.println(test.minimumAbsDifference(new int[]{40,11,26,27,-20}));
    }

}
