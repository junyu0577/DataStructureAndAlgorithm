package com.github.junyu.solution.leetCode.easy.others;

public class _762_Prime_Number_of_Set_Bits_in_Binary_Representation {

    /*
    Given two integers L and R, find the count of numbers in the range [L, R] (inclusive)
    having a prime number of set bits in their binary representation.

            (Recall that the number of set bits an integer has is the number of 1s
    present when written in binary. For example, 21 written in binary is 10101 which has 3
    set bits. Also, 1 is not a prime.)

    Example 1:

    Input: L = 6, R = 10
    Output: 4
    Explanation:
            6 -> 110 (2 set bits, 2 is prime)
            7 -> 111 (3 set bits, 3 is prime)
            9 -> 1001 (2 set bits , 2 is prime)
            10->1010 (2 set bits , 2 is prime)
    Example 2:

    Input: L = 10, R = 15
    Output: 5
    Explanation:
            10 -> 1010 (2 set bits, 2 is prime)
            11 -> 1011 (3 set bits, 3 is prime)
            12 -> 1100 (2 set bits, 2 is prime)
            13 -> 1101 (3 set bits, 3 is prime)
            14 -> 1110 (3 set bits, 3 is prime)
            15 -> 1111 (4 set bits, 4 is not prime)
    Note:

    L, R will be integers L <= R in the range [1, 10^6].
    R - L will be at most 10000.
    */

    /**
     * 计算L到R之间的数字转为二进制后，其中1的个数正好是素数的数量。
     * 遍历L到R，统计每个数的1的数量，由于题目做了上限是10的6次方，
     * 那么对应的可能出现的素数的最大值最多是19。
     * @param L
     * @param R
     * @return
     */
//    public int countPrimeSetBits(int L, int R) {
//        int ans = 0;
//        for (int i = L; i <= R; i++) {
//            int count = 0;
//            int cur = i;
//            while (cur > 0) {
//                if ((cur & 1) == 1)
//                    count++;
//                cur >>= 1;
//            }
//            if (count == 2 || count == 3 || count == 5 || count == 7 ||
//                    count == 11 || count == 13 || count == 17 || count == 19)
//                ans++;
//        }
//        return ans;
//    }

    /**
     * solution2
     * 对于统计1数量的步骤，java提供了更高效的方法，那么直接调用api就能获取
     * 效率上的提升( Integer.bitCount )
     * @param L
     * @param R
     * @return
     */
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R; i++) {
            int count = Integer.bitCount(i);
            if (count == 2 || count == 3 || count == 5 || count == 7 ||
                    count == 11 || count == 13 || count == 17 || count == 19)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _762_Prime_Number_of_Set_Bits_in_Binary_Representation().countPrimeSetBits(6, 10));
        System.out.println(new _762_Prime_Number_of_Set_Bits_in_Binary_Representation().countPrimeSetBits(10, 15));
        System.out.println(new _762_Prime_Number_of_Set_Bits_in_Binary_Representation().countPrimeSetBits(842, 888));
    }
}
