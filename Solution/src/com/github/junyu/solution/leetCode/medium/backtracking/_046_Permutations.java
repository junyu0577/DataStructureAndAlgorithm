package com.github.junyu.solution.leetCode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _046_Permutations {

   /* Given a collection of distinct integers, return all possible permutations.

            Example:

    Input: [1,2,3]
    Output:
            [
            [1,2,3],
            [1,3,2],
            [2,1,3],
            [2,3,1],
            [3,1,2],
            [3,2,1]
            ]
    */

    private List<List<Integer>> res;

    /**
     * 求全排列
     * 和017题不同之处在于，017在递归回溯期间不存在元素之间重复使用的问题，而全排列不能有重复的元素。
     * 所以为了防止出现重复元素，每次插入temp到集合前需要判断下是否已经存在，不存在则可以插入。
     * 最后递归到底时，将temp插入到res中。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        List<Integer> temp = new ArrayList<>();
        getPermutations(nums, 0, temp);

        return res;
    }

    private void getPermutations(int[] nums, int index, List<Integer> temp) {
        if (nums.length == index) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                getPermutations(nums, index + 1, temp);
                temp.remove((Integer) nums[i]);
            }

        }
    }


    public static void main(String[] args) {
        _046_Permutations permutations = new _046_Permutations();
        List<List<Integer>> list = permutations.permute(new int[]{1, 2, 3,4,5});
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println(list.size());
    }

}
