package com.github.junyu.solution.leetCode.easy.math;

public class _949_Largest_Time_for_Given_Digits {

    /*Given an array of 4 digits, return the largest 24 hour time that can be made.

    The smallest 24 hour time is 00:00, and the largest is 23:59.
    Starting from 00:00, a time is larger if more time has elapsed since midnight.

    Return the answer as a string of length 5.
    If no valid time can be made, return an empty string.

    Example 1:

    Input: [1,2,3,4]
    Output: "23:41"
    Example 2:

    Input: [5,5,5,5]
    Output: ""


    Note:

    A.length == 4
            0 <= A[i] <= 9*/

    public int res = -1;

    /**
     * 利用递归枚举出所有的排列，将这些排列放在StringBuild中，每当满足4个字符时，
     * 进行一次合法性的校验，前两位大于23以及后两位大于59都是非法的。如果是合法的，则
     * 和res进行比较大于res就更新，res保存的数的单位是分钟。
     * 在得到最大的res后，如果不是初始化的-1，就通过/60和%60再转化为时和分进行输出
     * @param A
     * @return
     */
    public String largestTimeFromDigits(int[] A) {

        boolean used[] = new boolean[4];

        getResult(new StringBuilder(), used, A);
        if (res == -1)
            return "";

        return String.format("%02d:%02d", res / 60, res % 60);

    }

    private void getResult(StringBuilder sb, boolean used[], int[] A) {
        if (sb.length() == 4) {
            int left = Integer.valueOf(sb.substring(0, 2));
            int right = Integer.valueOf(sb.substring(2));
            if (left > 23 || right > 59)
                return;

            res = Math.max(res, left * 60 + right);
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!used[i]) {
                used[i] = true;
                getResult(new StringBuilder(sb).append(A[i]), used, A);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        _949_Largest_Time_for_Given_Digits largest_time_for_given_digits = new _949_Largest_Time_for_Given_Digits();
//        System.out.println(largest_time_for_given_digits.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
//        System.out.println(largest_time_for_given_digits.largestTimeFromDigits(new int[]{5, 5, 5, 5}));
//        System.out.println(largest_time_for_given_digits.largestTimeFromDigits(new int[]{1, 2, 4, 5}));
        System.out.println(largest_time_for_given_digits.largestTimeFromDigits(new int[]{0, 4, 0, 0}));
//        System.out.println(largest_time_for_given_digits.largestTimeFromDigits(new int[]{0, 6, 2, 6}));
    }
}
