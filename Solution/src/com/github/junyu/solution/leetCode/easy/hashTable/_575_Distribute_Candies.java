package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.HashSet;
import java.util.Set;

public class _575_Distribute_Candies {


   /* Given an integer array with even length, where different numbers in this array represent
    different kinds of candies. Each number means one candy of the corresponding kind.
    You need to distribute these candies equally in number to brother and sister.
    Return the maximum number of kinds of candies the sister could gain.
    Example 1:
    Input: candies = [1,1,2,2,3,3]
    Output: 3
    Explanation:
    There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
    Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
    The sister has three different kinds of candies.
    Example 2:
    Input: candies = [1,1,2,3]
    Output: 2
    Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
    The sister has two different kinds of candies, the brother has only one kind of candies.
            Note:

    The length of the given array is in range [2, 10,000], and will be even.
    The number in given array is in range [-100,000, 100,000].*/

    /**
     * 将糖果平均分给姐弟，保证姐姐获取的种类最多。
     * 先统计糖果的种类，使用hashSet去保存，最后他的长度就是种类数。
     * 如果糖果总数/2大于等于种类数，那么种类数就是姐姐可以获取的最大种类数。
     * 如果小于，那么总数/2就是姐姐可获取的最大种类数。
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>(candies.length);
        for (int i : candies)
            set.add(i);

        return set.size() <= candies.length / 2 ? set.size() : candies.length / 2;
    }

    public static void main(String[] args) {
        _575_Distribute_Candies distribute_candies = new _575_Distribute_Candies();
        System.out.println(distribute_candies.distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println(distribute_candies.distributeCandies(new int[]{1,1,2,3}));
    }
}
