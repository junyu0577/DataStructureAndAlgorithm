package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;
import java.util.logging.Level;

public class _905_Sort_Array_By_Parity {

  /*  Given an array A of non-negative integers, return an array consisting of all the even elements of A,
    followed by all the odd elements of A.

    You may return any answer array that satisfies this condition.



            Example 1:

    Input: [3,1,2,4]
    Output: [2,4,3,1]
    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


    Note:

            1 <= A.length <= 5000
            0 <= A[i] <= 5000
*/

//    /**
//     * 将所有的奇数拍到所有的偶数后面
//     * 通过开辟一个等长的数组，然后使用begin和end两个指针分别指向头和尾，对A数组进行遍历。
//     * 如果是奇数就往end的位置插入，偶数则往begin位置插入，每次插入后，都需要对end--或者begin++。
//     * @param A
//     * @return
//     */
//    public int[] sortArrayByParity(int[] A) {
//        int arr[] = new int[A.length];
//
//        int begin = 0;
//        int end = A.length - 1;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] % 2 == 1) {
//                arr[end] = A[i];
//                end--;
//            } else {
//                arr[begin] = A[i];
//                begin++;
//            }
//        }
//
//        return arr;
//    }

//    /**
//     * solution2
//     * 不需要开辟额外空间，遍历A数组的时，如果当前是奇数，那么需要交换begin和end的位置，交换后对end--，如果继续判断这个begin是否为奇数，如果是偶数
//     * 则跳过对begin++。
//     * @param A
//     * @return
//     */
//    public int[] sortArrayByParity(int[] A) {
//
//        int begin = 0;
//        int end = A.length - 1;
//        while (begin < end) {
//            if (A[begin] % 2 == 1) {
//                int temp = A[end];
//                A[end] = A[begin];
//                A[begin] = temp;
//                end--;
//            } else {
//                begin++;
//            }
//        }
//
//        return A;
//    }

    /**
     * solution3
     * 思路类似solution2,同样定义两个头尾指针，不同之处在于，不是在头指针遇到偶数就直接与尾指针的元素进行交换，而是当头
     * 指针遇到偶数，尾指针遇到奇数时才进行交换,这样减少了交换的次数.
     * 则跳过对begin++。
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {

        int begin = 0;
        int end = A.length - 1;
        while (begin < end) {

            while (begin < end && (A[begin] & 1) == 0)
                begin++;

            while (begin < end && (A[end] & 1) == 1)
                end--;

            if (begin < end) {
                int temp = A[end];
                A[end] = A[begin];
                A[begin] = temp;
                begin++;
                end--;
            }

        }

        return A;
    }

    public static void main(String[] args) {
//        int A[] = new int[]{3, 1, 2, 4};
//        int A[] = new int[]{1, 3};
//        int A[] = new int[]{0,1,2};
//        int A[] = new int[]{0,2,4,1,6};
//        int A[] = new int[]{1,2,4,3};
        int A[] = new int[]{2, 1, 3, 4};
        System.out.println(Arrays.toString(new _905_Sort_Array_By_Parity().sortArrayByParity(A)));
    }

}
