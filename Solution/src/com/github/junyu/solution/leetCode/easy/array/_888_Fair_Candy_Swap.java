package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _888_Fair_Candy_Swap {

  /*  Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar
    of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.

    Since they are friends, they would like to exchange one candy bar each so that after
    the exchange, they both have the same total amount of candy.  (The total amount of candy
    a person has is the sum of the sizes of candy bars they have.)

    Return an integer array ans where ans[0] is the size of the candy bar that Alice
    must exchange, and ans[1] is the size of the candy bar that Bob must exchange.

    If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.



    Example 1:

    Input: A = [1,1], B = [2,2]
    Output: [1,2]
    Example 2:

    Input: A = [1,2], B = [2,3]
    Output: [1,2]
    Example 3:

    Input: A = [2], B = [1,3]
    Output: [2,3]
    Example 4:

    Input: A = [1,2,5], B = [2,4]
    Output: [5,4]


    Note:

            1 <= A.length <= 10000
            1 <= B.length <= 10000
            1 <= A[i] <= 100000
            1 <= B[i] <= 100000
    It is guaranteed that Alice and Bob have different total amounts of candy.
    It is guaranteed there exists an answer.*/

//    /**
//     * 交换A和B数组中的一个元素，使得A和B数组中的总和相等
//     * 先求出A和B的总和sum1和sum2，然后在A中取出元素放在B中（sum1-i）(sum2+i)，再B中取出一个元素放在A中（sum2-j）(sum1+j),
//     * 如果这时（sum2-j）==(sum1+j)，那么就找到了要交换的元素。如果总和不相等，继续在B中取一个元素，判断总和。当依次取完B中所有的都不相等，就开始在A中取第二个元素，
//     * 整个流程就类似交互排序
//     *
//     * @param A
//     * @param B
//     * @return
//     */
//    public int[] fairCandySwap(int[] A, int[] B) {
//        int sum1 = sum(A, 0);
//        int sum2 = sum(B, 0);
//
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B.length; j++) {
//                int cur1 = sum1-A[i];
//                int cur2 = sum2+A[i];
//                if (cur1+B[j]==cur2-B[j]){
//                    return new int[]{A[i],B[j]};
//                }
//            }
//        }
//        return new int[]{-1, -1};
//    }

    /**
     * 在上述的基础上继续了优化，先对两个数组进行一次排序，
     * 然后定义两个指针分别指向A和B的头部，然后开始比较从两个0位置的交互结果，如果A和总和大于B，那么说明需要从A的数组中取出更多的值去交换
     * 才能接近两个总和的平衡。反之则去B中取更大的数。若相等就说明startA和startB所指向的元素就是结果。
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = sum(A, 0);
        int sum2 = sum(B, 0);

        Arrays.sort(A);
        Arrays.sort(B);

        int startA = 0;
        int startB = 0;
        while (startA < A.length && startB < B.length) {
            int cur1 = sum1 - A[startA];
            int cur2 = sum2 + A[startA];
            if (cur1 + B[startB] == cur2 - B[startB]) {
                return new int[]{A[startA], B[startB]};
            } else if (cur1 + B[startB] > cur2 - B[startB]) {
                startA++;
            } else {
                startB++;
            }
        }
        return new int[]{-1, -1};
    }

    private int sum(int[] a, int index) {
        if (index > a.length - 1)
            return 0;
        return a[index] + sum(a, ++index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _888_Fair_Candy_Swap().fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new _888_Fair_Candy_Swap().fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(new _888_Fair_Candy_Swap().fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(new _888_Fair_Candy_Swap().fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
        System.out.println(Arrays.toString(new _888_Fair_Candy_Swap().fairCandySwap(new int[]{35, 17, 4, 24, 10
        }, new int[]{63, 21})));
    }
}
