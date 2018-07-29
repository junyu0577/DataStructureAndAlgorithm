package com.github.junyu.solution.leetCode.easy.array;

import com.github.junyu.solution.data_structure.binary_search_tree.segment_tree.Merge;
import com.github.junyu.solution.data_structure.binary_search_tree.segment_tree.SegmentTree;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/29 17:04
 */
public class _303_Range_Sum_Query_Immutable {


  /*  Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Example:
    Given nums = [-2, 0, 3, -5, 2, -1]

    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3
    Note:
    You may assume that the array does not change.
    There are many calls to sumRange function.*/

//    private Integer data[];
//    private SegmentTree<Integer> tree;
//
//    /**
//     * 使用线段树求解
//     *
//     * @param nums
//     */
//    public _303_Range_Sum_Query_Immutable(int[] nums) {
//        if (nums.length > 1) {
//            data = new Integer[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                data[i] = nums[i];
//            }
//            tree = new SegmentTree<>(data, new Merge<Integer>() {
//                @Override
//                public Integer merge(Integer a, Integer b) {
//                    return a + b;
//                }
//            });
//
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        if (tree != null)
//            return tree.query(i, j);
//        else
//            return -1;
//    }

    private int sums[];

    /**
     * 基于数组内容不可更改
     * 建立sums数组 第i个位置存储nums数组[0,...,i]的总和
     * @param nums
     */
    public _303_Range_Sum_Query_Immutable(int[] nums) {
        sums = new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            sums[i+1] = sums[i]+ nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }

    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        _303_Range_Sum_Query_Immutable range_sum_query_immutable = new _303_Range_Sum_Query_Immutable(nums);
        System.out.println(range_sum_query_immutable.sumRange(0, 2));
        System.out.println(range_sum_query_immutable.sumRange(2, 5));
        System.out.println(range_sum_query_immutable.sumRange(0, 5));
    }
}
