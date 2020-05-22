package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_Unique_Number_of_Occurrences {

   /* Given an array of integers arr, write a function that returns true
    if and only if the number of occurrences of each value in the array is unique.

    Example 1:

    Input: arr = [1,2,2,1,1,3]
    Output: true
    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
    No two values have the same number of occurrences.

    Example 2:

    Input: arr = [1,2]
    Output: false
    Example 3:

    Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
    Output: true


    Constraints:

            1 <= arr.length <= 1000
            -1000 <= arr[i] <= 1000*/

    /**
     * 判断数组是否符合元素出现的次数都是唯一的
     * 思路：先统计数字出现的次数，然后将这些次数插入到set集合中，如果插入失败则表示有重复次数。
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!set.add(entry.getValue()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _1207_Unique_Number_of_Occurrences test = new _1207_Unique_Number_of_Occurrences();
        System.out.println(test.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(test.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(test.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
