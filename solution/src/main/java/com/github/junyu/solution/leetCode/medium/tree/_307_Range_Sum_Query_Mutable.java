package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.binary_search_tree.segment_tree.Merge;
import com.github.junyu.solution.data_structure.binary_search_tree.segment_tree.SegmentTree;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/29 20:09
 */
public class _307_Range_Sum_Query_Mutable {


 /*   Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    The update(i, val) function modifies nums by updating the element at index i to val.

    Example:

    Given nums = [1, 3, 5]

    sumRange(0, 2) -> 9
    update(1, 2)
    sumRange(0, 2) -> 8
    Note:

    The array is only modifiable by the update function.
    You may assume the number of calls to update and sumRange function is distributed evenly.*/

    private Integer data[];
    private SegmentTree<Integer> tree;

    public _307_Range_Sum_Query_Mutable(int[] nums) {
        if (nums.length !=0) {
            data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            tree = new SegmentTree<>(data, new Merge<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        }
    }

    public void update(int i, int val) {
        if (tree != null)
            tree.set(i, val);
    }

    public int sumRange(int i, int j) {
        if (tree == null)
            return -1;
       return  tree.query(i, j);
    }

}
