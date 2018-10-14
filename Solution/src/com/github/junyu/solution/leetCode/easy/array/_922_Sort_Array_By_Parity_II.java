package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _922_Sort_Array_By_Parity_II {

  /*  Given an array A of non-negative integers, half of the integers in A are odd,
  and half of the integers are even.

    Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

    You may return any answer array that satisfies this condition.



            Example 1:

    Input: [4,2,5,7]
    Output: [4,5,2,7]
    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


            Note:

            2 <= A.length <= 20000
    A.length % 2 == 0
            0 <= A[i] <= 1000*/

//    /**
//     *  solution1
//     * 给数组排序 使得奇数索引的元素是奇数，偶数索引的元素是偶数
//     * 时间复杂度和空间复杂度都为O(n)的解法,遍历A数组，判断每个元素的奇偶，插入到res对应的odd和even位置，并维护两个变量+2。
//     *
//     * @param A
//     * @return
//     */
//    public int[] sortArrayByParityII(int[] A) {
//        int[] res = new int[A.length];
//
//        int even = 0;
//        int odd = 1;
//
//        for (int i = 0; i < A.length; i++) {
//            if ((A[i] & 1) == 1) {//odd
//                res[odd] = A[i];
//                odd += 2;
//            } else {
//                res[even] = A[i];
//                even += 2;
//            }
//        }
//
//        return res;
//    }

    /**
     * solution2
     * 给数组排序 使得奇数索引的元素是奇数，偶数索引的元素是偶数
     * 不使用额外空间的做法，同样是定义两个指针指向分别指向奇数和偶数索引，通过两个单独的循环去找到两个错误位置的元素，
     * 然后交互他们的位置。
     * 时间复杂度为O(n)
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int len = A.length - 1;

        while (odd <= len && even <= len) {
            while (odd<=len && (A[odd]&1)==1){
                odd+=2;
            }
            while (even<=len && (A[even]&1)==0){
                even+=2;
            }
            if (odd <= len && even <= len){
                int temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        _922_Sort_Array_By_Parity_II sort_array_by_parity_ii = new _922_Sort_Array_By_Parity_II();
        System.out.println(Arrays.toString(sort_array_by_parity_ii.sortArrayByParityII(new int[]{4, 1})));
        System.out.println(Arrays.toString(sort_array_by_parity_ii.sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(sort_array_by_parity_ii.sortArrayByParityII(new int[]{4, 2, 5, 7, 9, 10})));
        System.out.println(Arrays.toString(sort_array_by_parity_ii.sortArrayByParityII(new int[]{4, 2, 5, 7, 9, 10, 11, 12})));
    }
}
