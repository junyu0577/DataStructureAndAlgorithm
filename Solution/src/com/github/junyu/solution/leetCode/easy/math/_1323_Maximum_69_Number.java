package com.github.junyu.solution.leetCode.easy.math;

import java.util.ArrayList;
import java.util.List;

public class _1323_Maximum_69_Number {

    /*Given a positive integer num consisting only of digits 6 and 9.

    Return the maximum number you can get by changing at most one digit
            (6 becomes 9, and 9 becomes 6).


    Example 1:

    Input: num = 9669
    Output: 9969
    Explanation:
    Changing the first digit results in 6669.
    Changing the second digit results in 9969.
    Changing the third digit results in 9699.
    Changing the fourth digit results in 9666.
    The maximum number is 9969.
    Example 2:

    Input: num = 9996
    Output: 9999
    Explanation: Changing the last digit 6 to 9 results in the maximum number.
            Example 3:

    Input: num = 9999
    Output: 9999
    Explanation: It is better not to apply any change.


    Constraints:

            1 <= num <= 10^4
    num's digits are 6 or 9.*/


    /**
     * 思路：将数字转字符串，然后替换最前面的6为9，然后在转为数字
     * @param num
     * @return
     */
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        boolean isTurned = false;
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c=='6' && !isTurned){
                sb.append('9');
                isTurned = true;
            } else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

//    /**
//     * 6和9组成的最大数字，只能翻转一次
//     * 思路：先获取数字的所有位数，然后从最大的位数开始遍历，遇到6就修改为9，最后再求各位数之和。
//     *
//     * @param num
//     * @return
//     */
//    public int maximum69Number(int num) {
//        List<Integer> list = new ArrayList<>();
//        while (num != 0) {
//            list.add(num % 10);
//            num/=10;
//        }
//
//        for (int i=list.size()-1;i>=0;i--){
//            if (list.get(i)==6){
//                list.set(i,9);
//                break;
//            }
//        }
//
//        int ans = 0;
//        for (int i=0;i<list.size();i++){
//            ans += list.get(i)*Math.pow(10,i);
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        _1323_Maximum_69_Number test = new _1323_Maximum_69_Number();
        System.out.println(test.maximum69Number(9669));
        System.out.println(test.maximum69Number(9996));
        System.out.println(test.maximum69Number(9999));
    }


}
