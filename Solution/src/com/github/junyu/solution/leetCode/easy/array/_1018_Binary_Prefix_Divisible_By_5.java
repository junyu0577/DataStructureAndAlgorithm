package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _1018_Binary_Prefix_Divisible_By_5 {

    /*
        Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)

        Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

        Example 1:

        Input: [0,1,1]
        Output: [true,false,false]
        Explanation:
        The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
        Example 2:

        Input: [1,1,1]
        Output: [false,false,false]
        Example 3:

        Input: [0,1,1,1,1,1]
        Output: [true,false,false,false,true,false]
        Example 4:

        Input: [1,1,1,0,1]
        Output: [false,false,false,false,false]


        Note:

                1 <= A.length <= 30000
        A[i] is 0 or 1
    */

    /**
     * 数组中子串组成的二进制转为十进制后能否被5整除
     * 子串由于不断的加入新的元素，我们可以通过左移的方式来应对。设定初始值为0，
     * 开始循环对初始值进行左移，左移后会有两种情况，原始的数据可能为0或者1，所以在左移后为了保证
     * 数据的正确性，当为1时还需要加上1，所以可以通过或运算来应对。然后就得到了子串的十进制表示的数，将结果
     * mod数字5以后，为0则能被整除。
     * 在整个左移过程中，很快就会遇上整形溢出的问题，因此，我们在每次得到十进制表示的数后，就对结果进行mod，这样保证了数字
     * 不会因为过大而溢出。
     *
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int num : A) {
            sum = (sum << 1 | num) % 5;
            ans.add(sum == 0);
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new _1018_Binary_Prefix_Divisible_By_5().prefixesDivBy5(new int[]{1}));
        System.out.println(new _1018_Binary_Prefix_Divisible_By_5().prefixesDivBy5(new int[]{0, 1}));
        System.out.println(new _1018_Binary_Prefix_Divisible_By_5().prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println(new _1018_Binary_Prefix_Divisible_By_5().prefixesDivBy5(new int[]{1, 1, 1}));
        System.out.println(new _1018_Binary_Prefix_Divisible_By_5().prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        System.out.println(new _1018_Binary_Prefix_Divisible_By_5().prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));

    }
}
