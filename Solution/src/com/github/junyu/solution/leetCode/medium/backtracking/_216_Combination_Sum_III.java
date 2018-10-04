package com.github.junyu.solution.leetCode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _216_Combination_Sum_III {

 /*   Find all possible combinations of k numbers that add up to a number n, given that
    only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

            Note:

    All numbers will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:

    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Example 2:

    Input: k = 3, n = 9
    Output: [[1,2,6], [1,3,5], [2,3,4]]*/


    /**
     * 从1-9中选出k个和为n的数字，不可以有重复。
     * 使用递归回溯法，最终的终止条件为temp集合中元素为k时，并且n为0，那么就找到k个和为n的数，直接将temp添加进res中。
     * 再n不断减小的过程中，当发现n已经小于等于0了，那么也不断再去寻找k-1个数。
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum3(k, n, res, temp, 1);
        return res;
    }

    public void combinationSum3(int k, int n, List<List<Integer>> res, List<Integer> temp, int index) {
        if (temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (n<=0)
            return;

        for (int i = index; i <= 9; i++) {
            temp.add(i);
            combinationSum3(k, n - i, res, temp, i + 1);
            temp.remove((Integer) i);
        }
    }

    public static void main(String[] args) {
        _216_Combination_Sum_III combination_sum_iii = new _216_Combination_Sum_III();
        System.out.println(combination_sum_iii.combinationSum3(3, 9));
    }
}
