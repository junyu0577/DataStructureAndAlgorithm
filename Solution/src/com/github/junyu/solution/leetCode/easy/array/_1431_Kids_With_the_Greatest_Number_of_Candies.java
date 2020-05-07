package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1431_Kids_With_the_Greatest_Number_of_Candies {

   /* Given the array candies and the integer extraCandies, where candies[i]
    represents the number of candies that the ith kid has.

    For each kid check if there is a way to distribute extraCandies among the kids
    such that he or she can have the greatest number of candies among them. Notice
    that multiple kids can have the greatest number of candies.

    Example 1:

    Input: candies = [2,3,5,1,3], extraCandies = 3
    Output: [true,true,true,false,true]
    Explanation:
    Kid 1 has 2 candies and if he or she receives all extra candies (3) will have
    5 candies --- the greatest number of candies among the kids.
    Kid 2 has 3 candies and if he or she receives at least 2 extra candies will have
    the greatest number of candies among the kids.
    Kid 3 has 5 candies and this is already the greatest number of candies among the
    kids.
    Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies.
            Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have
    the greatest number of candies among the kids.
    Example 2:

    Input: candies = [4,2,1,1,2], extraCandies = 1
    Output: [true,false,false,false,false]
    Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest
    number of candies among the kids regardless of who takes the extra candy.

    Example 3:

    Input: candies = [12,1,12], extraCandies = 10
    Output: [true,false,true]


    Constraints:

            2 <= candies.length <= 100
            1 <= candies[i] <= 100
            1 <= extraCandies <= 50
*/

    /**
     * 将额外的糖分给孩子以后，孩子是否能成为拥有糖数最多的人
     * 先找出数组里拥有的最大糖果数值，然后再次遍历数组，将每个人的拥有的糖果数加上额外给的糖果数，
     * 如果结果大于获取到的拥有糖果最大值，那么当前的孩子就可以成为拥有糖果数最多的人。
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = candies[0];

        for (int i = 1; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            ans.add(candies[i] + extraCandies >= maxCandies);
        }

        return ans;
    }

    public static void main(String[] args) {
        _1431_Kids_With_the_Greatest_Number_of_Candies test = new _1431_Kids_With_the_Greatest_Number_of_Candies();
        System.out.println(test.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(test.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(test.kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

}
