package com.github.junyu.solution.leetCode.easy.others;


public class _1012_Complement_of_Base_10_Integer {

    /*
    Every non-negative integer N has a binary representation.  For example,
    5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.
    Note that except for N = 0, there are no leading zeroes in any binary representation.

    The complement of a binary representation is the number in binary you get
    when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101"
    in binary is "010" in binary.

    For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.



    Example 1:

    Input: 5
    Output: 2
    Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
    Example 2:

    Input: 7
    Output: 0
    Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
    Example 3:

    Input: 10
    Output: 5
    Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.


    Note:

            0 <= N < 10^9
*/

    /**
     * 求数字转为二进制后进行0和1的置换，然后将结果转为十进制返回
     * 通过与运算求出从低位开始的数，如果当前是0则进行2的n次方运算并求和。
     * @param N
     * @return
     */
    public int bitwiseComplement(int N) {
        if (N == 0)
            return 1;

        int ans = 0;
        int step = 0;
        while (N > 0) {
            if ((N & 1) == 0)
                ans += Math.pow(2, step);
            N = N >> 1;
            step++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _1012_Complement_of_Base_10_Integer().bitwiseComplement(5));
        System.out.println(new _1012_Complement_of_Base_10_Integer().bitwiseComplement(7));
        System.out.println(new _1012_Complement_of_Base_10_Integer().bitwiseComplement(10));
        System.out.println();
    }
}
