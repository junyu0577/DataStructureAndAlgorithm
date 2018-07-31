package com.github.junyu.solution.leetCode.easy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaoJunyu
 * @since 2018/7/31 14:02
 */
public class Roman_to_Integer {

/*    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

            Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven
     is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written
     as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
     There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:

    Input: 'III'
    Output: 3
    Example 2:

    Input: 'IV'
    Output: 4
    Example 3:

    Input: 'IX'
    Output: 9
    Example 4:

    Input: 'LVIII'
    Output: 58
    Explanation: C = 100, L = 50, XXX = 30 and III = 3.
    Example 5:

    Input: 'MCMXCIV'
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.*/


    /**
     * 将字符和对应的数值存入map，然后遍历字符串进行比较，如果前面的数面值大于等于后者，进行累加。
     * 反之递减。由于在比较过程中并没有将最后的一个元素计算进来，最后需要单独计入。
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int i = 0;
        char cs[] = s.toCharArray();
        int pre = map.get(cs[i]);
        for (; i < cs.length - 1; i++) {
            int cur = map.get(cs[i + 1]);
            if (pre >= cur)//大于后者 累加
                sum += pre;
            else
                sum -= pre;

            pre = cur;
        }

        sum += map.get(cs[i]);

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

}
