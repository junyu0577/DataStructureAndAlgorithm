package com.github.junyu.solution.leetCode.easy.array;

public class _414_Third_Maximum_Number {

    /*Given a non-empty array of integers, return the third maximum number in this array. If it does not exist,
            return the maximum number. The time complexity must be in O(n).

    Example 1:
    Input: [3, 2, 1]

    Output: 1

    Explanation: The third maximum is 1.
    Example 2:
    Input: [1, 2]

    Output: 2

    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
    Example 3:
    Input: [2, 2, 3, 1]

    Output: 1

    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.*/

    /**
     * 找出第三大的数，如果不足三个则返回最大的数
     *
     * 思路：n1最大,n2次大,n3第三,按顺序判断，先比较最大的数，如果是空或者比最大的数n1大，则更新更新n1,n2,n3,同时注意如果是遇到相同的数，
     * 不对这三个值进行任何更新。
     * 最后判断n3是否为空，为空就返回n1，不为空就返回n3.
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Integer n1 = null;
        Integer n2 = null;
        Integer n3 = null;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (n1 == null || val > n1) {
                n3 = n2;
                n2 = n1;
                n1 = nums[i];
            } else if (n1 == val) {
            } else if (n2 == null || val > n2) {
                n3 = n2;
                n2 = nums[i];
            } else if (n2 == val) {
            } else if (n3 == null || val > n3) {
                n3 = nums[i];
            }
        }
        if (n3 == null)
            return n1;
        return n3;
    }

    public static void main(String[] args) {
        _414_Third_Maximum_Number test = new _414_Third_Maximum_Number();
        System.out.println(test.thirdMax(new int[]{3, 2, 1}));
        System.out.println(test.thirdMax(new int[]{1, 2}));
        System.out.println(test.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(test.thirdMax(new int[]{1, 2, -2147483648}));
    }

}
