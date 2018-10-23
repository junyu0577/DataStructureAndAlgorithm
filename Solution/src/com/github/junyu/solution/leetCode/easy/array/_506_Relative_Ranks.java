package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _506_Relative_Ranks {

    /*Given scores of N athletes, find their relative ranks and the people
    with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

    Example 1:
    Input: [5, 4, 3, 2, 1]
    Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
    Explanation: The first three athletes got the top three highest scores,
    so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
    For the left two athletes, you just need to output their relative ranks according to their scores.
    Note:
    N is a positive integer and won't exceed 10,000.
    All the scores of athletes are guaranteed to be unique.*/

    /**
     * 给数组中的分数进行排名。
     * 先统计最大的分数，然后开辟分数值+1长度的hash表。
     * 遍历原数组，将他们的位置+1后插入到hash表分数对应的位置。
     * 最后遍历hash表，hash表保存的是从小到大分数的索引位置。
     * 根据索引位置-1，将排名赋值给res数组。
     *
     *
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] hash = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i+1;
        }


        int count = 1;
        String[] res = new String[nums.length];
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (count == 1) {
                    res[hash[i]-1] = "Gold Medal";
                    count++;
                } else if (count == 2) {
                    res[hash[i]-1] = "Silver Medal";
                    count++;
                } else if (count == 3) {
                    res[hash[i]-1] = "Bronze Medal";
                    count++;
                } else {
                    res[hash[i]-1] = String.valueOf(count);
                    count++;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        _506_Relative_Ranks relative_ranks = new _506_Relative_Ranks();
        System.out.println(Arrays.toString(relative_ranks.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

}
