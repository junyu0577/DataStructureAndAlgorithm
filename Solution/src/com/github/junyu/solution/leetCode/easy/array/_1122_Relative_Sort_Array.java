package com.github.junyu.solution.leetCode.easy.array;

import java.util.*;

public class _1122_Relative_Sort_Array {


    /*Given two arrays arr1 and arr2, the elements of arr2 are distinct,
    and all elements in arr2 are also in arr1.

    Sort the elements of arr1 such that the relative ordering of items in arr1 are
    the same as in arr2.  Elements that don't
    appear in arr2 should be placed at the end of arr1 in ascending order.

    Example 1:

    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    Output: [2,2,2,1,4,3,3,9,6,7,19]

    Constraints:

    arr1.length, arr2.length <= 1000
            0 <= arr1[i], arr2[i] <= 1000
    Each arr2[i] is distinct.
    Each arr2[i] is in arr1.*/


    /**
     * 思路:由于两个数组的取值范围在0-1000，那么我们可以定义一个长度为1001的哈希表去保存arr1中元素出现的
     * 次数。然后遍历arr2的元素，插入哈希表对应的数量个数的元素到结果数组中。最后再单独遍历一次哈希表，将剩余
     * 数量大于1的元素插入到结果数组中。
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int[] ans = new int[len];

        int[] count = new int[1001];
        for (int i = 0; i < arr1.length; i++)
            count[arr1[i]]++;

        int index = 0;
        for (int num : arr2) {
            while (count[num]-- > 0) {
                ans[index++] = num;
            }
        }

        for (int i=0;i<count.length;i++) {
            while (count[i]-->0){
                ans[index++] = i;
            }
        }

        return ans;
    }

//    /**
//     * 将arr1的元素按照arr2的顺序进行排序
//     * 思路:通过treeMap统计arr1中元素出现的次数，treeMap本身自带升序排序。
//     * 然后遍历arr2数组，将当前元素插入到结果数组中，插入的时候根据treeMap的value，同时插入完成
//     * 后移除map中的元素。
//     * 最后arr1中可能存在arr2中没有的元素，因为还需要再迭代一次map，将剩余的元素按升序插入到结果
//     * 数组中。
//     *
//     * @param arr1
//     * @param arr2
//     * @return
//     */
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int len = arr1.length;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int i = 0; i < len; i++) {
//            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
//        }
//
//        int[] ans = new int[len];
//        int index = 0;
//        for (int i = 0; i < arr2.length; i++) {
//            int cur = arr2[i];
//            int count = map.get(cur);
//            for (int j = 0; j < count; j++) {
//                ans[index++] = cur;
//            }
//            map.remove(cur);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet())
//            for (int i = 0; i < entry.getValue(); i++)
//                ans[index++] = entry.getKey();
//
//        return ans;
//    }

    public static void main(String[] args) {
        _1122_Relative_Sort_Array test = new _1122_Relative_Sort_Array();
        System.out.println(Arrays.toString(
                test.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                        new int[]{2, 1, 4, 3, 9, 6})));
//
        System.out.println(Arrays.toString(
                test.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17},
                        new int[]{22, 28, 8, 6})));

        System.out.println(Arrays.toString(
                test.relativeSortArray(new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31},
                        new int[]{2, 42, 38, 0, 43, 21})));

//        [2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48]
    }

}
