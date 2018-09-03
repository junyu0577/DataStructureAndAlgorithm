package com.github.junyu.solution.leetCode.easy.array;

public class _896_Monotonic_Array {

   /* An array is monotonic if it is either monotone increasing or monotone decreasing.

    An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

    Return true if and only if the given array A is monotonic.



    Example 1:

    Input: [1,2,2,3]
    Output: true
    Example 2:

    Input: [6,5,4,4]
    Output: true
    Example 3:

    Input: [1,3,2]
    Output: false
    Example 4:

    Input: [1,2,4,5]
    Output: true
    Example 5:

    Input: [1,1,1]
    Output: true


    Note:

            1 <= A.length <= 50000
            -100000 <= A[i] <= 100000*/

    /**
     * 判断数组是否是递增 或者递减
     * 定义一个status进行初始判断整个数组是递增还是递减，还是相等，然后从第二个元素开始与前一个元素进行比较，这里一共有五种情况：
     * 1.后序是递增，但是之前的status是递减 返回false；
     * 2.后序是递减，之前的是递增 返回false；
     * 3.后序是递减，之前是相等，那么更改status为递减-1
     * 4.后序是递增，之前是相等，更改status为1。
     * 5.其他情况正常，进行遍历比较下一个元素。
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0)
            return false;

        if (A.length == 1)
            return true;

        int status;

        if (A[1] > A[0]) {
            status = 1;
        } else if (A[1] < A[0]) {
            status = -1;
        } else {
            status = 0;
        }

        for (int i = 2; i < A.length; i++) {
            if (A[i] > A[i - 1] && status == -1) {
                return false;
            } else if (A[i] < A[i - 1] && status == 1)
                return false;
            else if (A[i] > A[i - 1] && status == 0) {
                status = 1;
            } else if (A[i] < A[i - 1] && status == 0) {
                status = -1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _896_Monotonic_Array().isMonotonic(new int[]{1,2,2,3}));
        System.out.println(new _896_Monotonic_Array().isMonotonic(new int[]{6,5,4,4}));
        System.out.println(new _896_Monotonic_Array().isMonotonic(new int[]{1,3,2}));
        System.out.println(new _896_Monotonic_Array().isMonotonic(new int[]{1,1,1}));
        System.out.println(new _896_Monotonic_Array().isMonotonic(new int[]{1, 1, 0}));
        System.out.println(new _896_Monotonic_Array().isMonotonic(new int[]{0,0,1}));
        System.out.println(new _896_Monotonic_Array().isMonotonic(new int[]{2, 2, 2, 1, 4, 5}));
    }

}
