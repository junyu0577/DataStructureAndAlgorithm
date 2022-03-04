package com.github.junyu.solution.leetCode.easy.math;

public class _2169_Count_Operations_to_Obtain_Zero {

    /*
    You are given two non-negative integers num1 and num2.

    In one operation, if num1 >= num2, you must subtract num2 from num1, otherwise subtract num1 from num2.

    For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus obtaining num1 = 1 and num2 = 4. However, if num1 = 4 and num2 = 5, after one operation, num1 = 4 and num2 = 1.
    Return the number of operations required to make either num1 = 0 or num2 = 0.



    Example 1:

    Input: num1 = 2, num2 = 3
    Output: 3
    Explanation:
            - Operation 1: num1 = 2, num2 = 3. Since num1 < num2, we subtract num1 from num2 and get num1 = 2, num2 = 3 - 2 = 1.
            - Operation 2: num1 = 2, num2 = 1. Since num1 > num2, we subtract num2 from num1.
- Operation 3: num1 = 1, num2 = 1. Since num1 == num2, we subtract num2 from num1.
            Now num1 = 0 and num2 = 1. Since num1 == 0, we do not need to perform any further operations.
    So the total number of operations required is 3.

    Example 2:

    Input: num1 = 10, num2 = 10
    Output: 1
    Explanation:
            - Operation 1: num1 = 10, num2 = 10. Since num1 == num2, we subtract num2 from num1 and get num1 = 10 - 10 = 0.
    Now num1 = 0 and num2 = 10. Since num1 == 0, we are done.
    So the total number of operations required is 1.


    Constraints:

            0 <= num1, num2 <= 105
    */

    /**
     * 使得num1或者num2 等于 0 的操作数
     *
     * 在模拟前可以提前排除掉一些情况以降低整体模拟的次数。
     * 1.一开始就有等于0的情况
     * 2.能够被整除的情况，操作数就等于大数/小数的值
     *
     * Runtime: 2 ms, faster than 73.92% of Java online submissions for Count Operations to Obtain Zero.
     * Memory Usage: 41.2 MB, less than 45.39% of Java online submissions for Count Operations to Obtain Zero.
     *
     * @param num1
     * @param num2
     * @return
     */
    public int countOperations(int num1, int num2) {
        int ans = 0;
        if (num1 == 0 || num2 == 0)
            return 0;

        if (num1 % num2 == 0)
            return num1 / num2;

        if (num2 % num1 == 0)
            return num2 / num1;

        while (num1 != 0 && num2 != 0) {
            ans++;
            if (num1 > num2)
                num1 = num1 - num2;
            else if (num2 > num1)
                num2 = num2 - num1;
            else
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        _2169_Count_Operations_to_Obtain_Zero test = new _2169_Count_Operations_to_Obtain_Zero();
        System.out.println(test.countOperations(2, 3));
        System.out.println(test.countOperations(10, 10));
        System.out.println(test.countOperations(8, 8));
        System.out.println(test.countOperations(8, 4));
        System.out.println(test.countOperations(8, 7));
        System.out.println(test.countOperations(8, 1));
        System.out.println(test.countOperations(8, 2));
        System.out.println(test.countOperations(11, 3));
        System.out.println(test.countOperations(13, 3));
        System.out.println(test.countOperations(14, 3));
        System.out.println(test.countOperations(15, 0));
    }
}
