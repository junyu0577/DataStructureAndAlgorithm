package com.github.junyu.solution.leetCode.easy.math;

import java.util.HashMap;

public class _2053_Kth_Distinct_String_in_an_Array {


/*

    A distinct string is a string that is present only once in an array.

    Given an array of strings arr, and an integer k, return the kth distinct
    string present in arr. If there are fewer than k distinct strings, return
    an empty string "".

    Note that the strings are considered in the order in which they appear
    in the array.



    Example 1:

    Input: arr = ["d","b","c","b","c","a"], k = 2
    Output: "a"
    Explanation:
    The only distinct strings in arr are "d" and "a".
            "d" appears 1st, so it is the 1st distinct string.
    "a" appears 2nd, so it is the 2nd distinct string.
    Since k == 2, "a" is returned.


    Example 2:

    Input: arr = ["aaa","aa","a"], k = 1
    Output: "aaa"
    Explanation:
    All strings in arr are distinct, so the 1st string "aaa" is returned.


    Example 3:

    Input: arr = ["a","b","a"], k = 3
    Output: ""
    Explanation:
    The only distinct string is "b". Since there are fewer than 3
    distinct strings, we return an empty string "".


    Constraints:

            1 <= k <= arr.length <= 1000
            1 <= arr[i].length <= 5
    arr[i] consists of lowercase English letters.
*/


    /**
     * 数组中第 K 个独一无二的字符串
     * 首先通过hashMap统计出现的字符串字数，然后再次遍历数组，当出现第k个数量为1的字符串时返回。
     *
     * Runtime: 4 ms, faster than 96.15% of Java online submissions for Kth Distinct String in an Array.
     * Memory Usage: 38.8 MB, less than 74.91% of Java online submissions for Kth Distinct String in an Array.
     * @param arr
     * @param k
     * @return
     */
    public String kthDistinct(String[] arr, int k) {
        String ans = "";
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int count = 1;
        for (int i=0;i<arr.length;i++){
            if (map.get(arr[i])==1){
                if (count==k)
                    return arr[i];
                else
                    count++;
            }
        }
        return ans;
    }

    public static void main(String [] args) {
        _2053_Kth_Distinct_String_in_an_Array test = new _2053_Kth_Distinct_String_in_an_Array();
        System.out.println(test.kthDistinct(new String[]{"d","b","c","b","c","a"},2));
        System.out.println(test.kthDistinct(new String[]{"aaa","aa","a"},1));
        System.out.println(test.kthDistinct(new String[]{"a","b","a"},3));
    }
}
