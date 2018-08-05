package com.github.junyu.solution.leetCode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _077_Combinations {


  /*  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

            Example:

    Input: n = 4, k = 2
    Output:
            [
            [2,4],
            [3,4],
            [2,3],
            [1,2],
            [1,3],
            [1,4],
            ]
    */


    private List<List<Integer>> res;


    /**
     * 组合问题
     * 从n个元素中取k个
     * 递归过程中不断向后取值就可以了，因为前面已经排除了前面的元素，所以也就不存在重复组合问题。
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        getCombinations(n, k, 1, temp);

        return res;
    }

    private void getCombinations(int n, int k, int start, List<Integer> temp) {
        if (k == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        //n - (k - temp.size()) + 1 <= n  剪枝 减少一些多余的搜索
        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            getCombinations(n, k, i + 1, temp);
            temp.remove((Integer) i);
        }
    }

    public static void main(String[] args) {
        _077_Combinations combinations = new _077_Combinations();
        List<List<Integer>> list = combinations.combine(4, 2);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println(list.size());
    }
}
