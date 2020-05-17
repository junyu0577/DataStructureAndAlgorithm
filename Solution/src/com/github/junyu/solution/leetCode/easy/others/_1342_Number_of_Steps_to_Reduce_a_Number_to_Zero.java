package com.github.junyu.solution.leetCode.easy.others;

public class _1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {

    /*Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even,
    you have to divide it by 2, otherwise, you have to subtract 1 from it.

    Example 1:

    Input: num = 14
    Output: 6
    Explanation:
    Step 1) 14 is even; divide by 2 and obtain 7.
    Step 2) 7 is odd; subtract 1 and obtain 6.
    Step 3) 6 is even; divide by 2 and obtain 3.
    Step 4) 3 is odd; subtract 1 and obtain 2.
    Step 5) 2 is even; divide by 2 and obtain 1.
    Step 6) 1 is odd; subtract 1 and obtain 0.
    Example 2:

    Input: num = 8
    Output: 4
    Explanation:
    Step 1) 8 is even; divide by 2 and obtain 4.
    Step 2) 4 is even; divide by 2 and obtain 2.
    Step 3) 2 is even; divide by 2 and obtain 1.
    Step 4) 1 is odd; subtract 1 and obtain 0.
    Example 3:

    Input: num = 123
    Output: 12


    Constraints:

            0 <= num <= 10^6
*/

    /**
     * 将数字化解到0需要多少步骤，如果是偶数除2，奇数则减1。
     * 思路：只要num不为0，就不断对num进行判断，如果是偶数则右移1位，奇数则递减1，每次循环都为1次步骤。
     * @param num
     * @return
     */
    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num--;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        _1342_Number_of_Steps_to_Reduce_a_Number_to_Zero test = new _1342_Number_of_Steps_to_Reduce_a_Number_to_Zero();
        System.out.println(test.numberOfSteps(14));
        System.out.println(test.numberOfSteps(8));
        System.out.println(test.numberOfSteps(123));
    }
}
