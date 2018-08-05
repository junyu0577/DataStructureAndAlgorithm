package com.github.junyu.solution.leetCode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _078_Subsets {

    /*Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]
    Output:
            [
            [3],
            [1],
            [2],
            [1,2,3],
            [1,3],
            [2,3],
            [1,2],
            []
            ]
    */

    private List<List<Integer>> res;

    /**
     * 求数组的所有子集
     *
     * 注意点就是在回溯过程中，要剔除之前已经加入的元素
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        List<Integer> temp = new ArrayList<>();
        getSubsets(nums, 0, temp);

        return res;
    }

    private void getSubsets(int[] nums, int index, List<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            getSubsets(nums, i + 1, temp);
            temp.remove((Integer) nums[i]);
        }
    }

    public static void main(String[] args) {
        _078_Subsets subsets = new _078_Subsets();
        List<List<Integer>> list = subsets.subsets(new int[]{1, 2, 3});
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println(list.size());
    }

}
