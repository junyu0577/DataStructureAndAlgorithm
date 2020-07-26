package com.github.junyu.solution.leetCode.easy.array;

public class _1523_Count_Odd_Numbers_in_an_Interval_Range {

    /*Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

    Example 1:

    Input: low = 3, high = 7
    Output: 3
    Explanation: The odd numbers between 3 and 7 are [3,5,7].
    Example 2:

    Input: low = 8, high = 10
    Output: 1
    Explanation: The odd numbers between 8 and 10 are [9].


    Constraints:

            0 <= low <= high <= 10^9
*/

    /**
     * 区间范围内奇数的数量
     * 思路：判断开始位置是否是奇数，如果是奇数，那么后面的排列中肯定是偶奇偶奇这么排序，偶数要多于奇数，就代表一半以上是偶数，所以将high和low的差值除2即可获取从low+1到high之间
     * 的奇数的数量，然后在补上low这个奇数。
     * 如果是偶数，那么后面的奇数占一半之上，所以将diff+1后再除2获取奇数的数量(3个里面有2个奇数，5个中有3个奇数)。
     * @param low
     * @param high
     * @return
     */
    public int countOdds(int low, int high) {
        int diff = high - low;
        int ans = 0;
        boolean isOdd = (low & 1) == 1;
        if (isOdd) {
            ans += diff / 2 + 1;
        } else {
            ans += (diff + 1) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1523_Count_Odd_Numbers_in_an_Interval_Range test = new _1523_Count_Odd_Numbers_in_an_Interval_Range();
        System.out.println(test.countOdds(3, 7));
        System.out.println(test.countOdds(3, 6));
        System.out.println(test.countOdds(4, 7));
        System.out.println(test.countOdds(8, 10));
    }
}
