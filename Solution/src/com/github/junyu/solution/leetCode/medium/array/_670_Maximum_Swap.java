package com.github.junyu.solution.leetCode.medium.array;

import java.util.ArrayList;
import java.util.List;

public class _670_Maximum_Swap {
/*
    Given a non-negative integer, you could swap two digits at most once to get the maximum
    valued number. Return the maximum valued number you could get.

    Example 1:
    Input: 2736
    Output: 7236
    Explanation: Swap the number 2 and the number 7.
    Example 2:
    Input: 9973
    Output: 9973
    Explanation: No swap.
    Note:
    The given number is in the range [0, 108]*/


    /**
     * 交换一次num中的两个数，让num变成它能够变成的最大值
     * 先将num通过取余的方式装进集合，遍历集合里的元素，每个元素再和后续的所有的元素做比较，如果有元素大于大于当前，就交换。
     *
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        if (num < 10)
            return num;
        int res = num;
        List<Integer> nums = new ArrayList<>();
        while (res > 0) {
            nums.add(0, res % 10);
            res = res / 10;
        }

        boolean isOver = false;
        for (int i = 0; i < nums.size(); i++) {
            int max = i;
            //找出最大值和以前的数进行比较

            for (int j = nums.size()-1; j > i ; j--) {
                if (nums.get(max) < nums.get(j)) {
                    max = j;
                }
            }
            if (max == i)//当前即是最大值
                continue;

            //找到合适的位置交换 从0开始找
            for (int k = 0; k < nums.size(); k++) {
                if (nums.get(k) < nums.get(max)) {
                    int temp = nums.get(k);
                    nums.set(k, nums.get(max));
                    nums.set(max, temp);
                    isOver = true;
                    break;
                }
            }
            if (isOver)
                break;
        }

        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result = result * 10 + nums.get(i);
        }

        return result;

    }

    public static void main(String[] args) {
        _670_Maximum_Swap maximum_swap = new _670_Maximum_Swap();
        System.out.println(maximum_swap.maximumSwap(2736));
        System.out.println(maximum_swap.maximumSwap(9973));
        System.out.println(maximum_swap.maximumSwap(98368));
        System.out.println(maximum_swap.maximumSwap(1993));
    }

}
