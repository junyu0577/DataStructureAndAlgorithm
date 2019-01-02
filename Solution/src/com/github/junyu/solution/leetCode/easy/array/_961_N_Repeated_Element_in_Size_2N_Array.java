package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class _961_N_Repeated_Element_in_Size_2N_Array {

   /* In a array A of size 2N, there are N+1 unique elements,
    and exactly one of these elements is repeated N times.

    Return the element repeated N times.

    Example 1:

    Input: [1,2,3,3]
    Output: 3
    Example 2:

    Input: [2,1,2,5,3,2]
    Output: 2
    Example 3:

    Input: [5,1,5,2,5,3,5,4]
    Output: 5

    Note:
            4 <= A.length <= 10000
            0 <= A[i] < 10000
    A.length is even

    */

    /**
     * 查找出重复出现的数字
     * 利用hashSet的唯一性，如果插入失败就表示当前的元素是重复元素
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        Set<Integer> hash = new HashSet<>();
        for (int i:A){
            if (!hash.add(i)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        _961_N_Repeated_Element_in_Size_2N_Array testCase = new _961_N_Repeated_Element_in_Size_2N_Array();
        System.out.println(testCase.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(testCase.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(testCase.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
        System.out.println(testCase.repeatedNTimes(new int[]{2,6,2,1}));
    }
}
