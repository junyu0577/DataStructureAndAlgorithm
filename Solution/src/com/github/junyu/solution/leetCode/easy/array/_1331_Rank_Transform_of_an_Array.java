package com.github.junyu.solution.leetCode.easy.array;


import java.util.Arrays;
import java.util.HashMap;

public class _1331_Rank_Transform_of_an_Array {

    /*Given an array of integers arr, replace each element with its rank.

    The rank represents how large the element is. The rank has the following rules:

    Rank is an integer starting from 1.
    The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
    Rank should be as small as possible.


            Example 1:

    Input: arr = [40,10,20,30]
    Output: [4,1,2,3]
    Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
    Example 2:

    Input: arr = [100,100,100]
    Output: [1,1,1]
    Explanation: Same elements share the same rank.
    Example 3:

    Input: arr = [37,12,28,9,100,56,80,5,12]
    Output: [5,3,4,2,8,6,7,1,3]


    Constraints:

            0 <= arr.length <= 105
            -109 <= arr[i] <= 109*/

    /**
     * 数组序号转换
     * 思路：先拷贝一份数组newArr，对newArr进行排序后，通过遍历将每个元素的排名记录到map到，key为本身，value为排名。
     * 最后再遍历原数组，从map中取出对应的排名进行覆盖。
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return arr;
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int[] newArr = Arrays.copyOf(arr, arr.length);

        Arrays.sort(newArr);
        int rank = 1;
        rankMap.put(newArr[0], rank);
        for (int i = 1; i < newArr.length; i++) {
            if (newArr[i] != newArr[i - 1]) {
                rank++;
            }
            rankMap.put(newArr[i], rank);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        _1331_Rank_Transform_of_an_Array test = new _1331_Rank_Transform_of_an_Array();
        System.out.println(Arrays.toString(test.arrayRankTransform(new int[]{40, 10, 20, 30})));
        System.out.println(Arrays.toString(test.arrayRankTransform(new int[]{100, 100, 100})));
        System.out.println(Arrays.toString(test.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));
        System.out.println(Arrays.toString(test.arrayRankTransform(new int[]{})));
        System.out.println(Arrays.toString(test.arrayRankTransform(new int[]{1})));
    }
}
