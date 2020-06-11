package com.github.junyu.solution.leetCode.easy.array;

public class _1460_Make_Two_Arrays_Equal_by_Reversing_Sub_arrays {

    /*Given two integer arrays of equal length target and arr.

    In one step, you can select any non-empty sub-array of arr and reverse it.
    You are allowed to make any number of steps.

    Return True if you can make arr equal to target, or False otherwise.

    Example 1:

    Input: target = [1,2,3,4], arr = [2,4,1,3]
    Output: true
    Explanation: You can follow the next steps to convert arr to target:
            1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
            2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
            3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
    There are multiple ways to convert arr to target, this is not the only way to do so.
            Example 2:

    Input: target = [7], arr = [7]
    Output: true
    Explanation: arr is equal to target without any reverses.
    Example 3:

    Input: target = [1,12], arr = [12,1]
    Output: true
    Example 4:

    Input: target = [3,7,9], arr = [3,7,11]
    Output: false
    Explanation: arr doesn't have value 9 and it can never be converted to target.
    Example 5:

    Input: target = [1,1,1,1,1], arr = [1,1,1,1,1]
    Output: true


    Constraints:

    target.length == arr.length
    1 <= target.length <= 1000
            1 <= target[i] <= 1000
            1 <= arr[i] <= 1000
    */

    /**
     * 翻转子数组使得两个数组相等
     * 思路：统计target元素出现的次数，然后遍历arr的时候减去对应元素出现的次数，
     * 期间如果有元素次数小于0，则出现两个数组有不同的元素，则条件不成立。
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int num : target) {
            count[num]++;
        }

        for (int num : arr) {
            count[num]--;
            if (count[num] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _1460_Make_Two_Arrays_Equal_by_Reversing_Sub_arrays test = new _1460_Make_Two_Arrays_Equal_by_Reversing_Sub_arrays();
        System.out.println(test.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        System.out.println(test.canBeEqual(new int[]{7}, new int[]{7}));
        System.out.println(test.canBeEqual(new int[]{1, 12}, new int[]{12, 1}));
        System.out.println(test.canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
        System.out.println(test.canBeEqual(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }
}
