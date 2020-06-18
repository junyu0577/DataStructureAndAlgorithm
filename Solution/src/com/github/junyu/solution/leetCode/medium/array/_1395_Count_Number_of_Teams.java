package com.github.junyu.solution.leetCode.medium.array;

public class _1395_Count_Number_of_Teams {

   /* There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

    You have to form a team of 3 soldiers amongst them under the following rules:

    Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
    A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j
     < k < n).
    Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



    Example 1:

    Input: rating = [2,5,3,4,1]
    Output: 3
    Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
    Example 2:

    Input: rating = [2,1,3]
    Output: 0
    Explanation: We can't form any team given the conditions.
    Example 3:

    Input: rating = [1,2,3,4]
    Output: 4


    Constraints:

    n == rating.length
    1 <= n <= 200
    1 <= rating[i] <= 10^5*/

    /**
     * 统计作战单位数
     * 思路：从一个士兵为中心点，统计左右两边大于和小于他的数量，统计出数量后，计算可行的排列数量通过
     * (升序：左小*右大的数量，降序：左大*右小的数量)，累加求和。
     *
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        int len = rating.length;
        int count = 0;

        for (int i = 1; i < len - 1; i++) {
            int leftSmall = 0, rightSmall = 0, leftGreat = 0, rightGreat = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    leftSmall++;
                else if (rating[j] > rating[i])
                    leftGreat++;
            }
            for (int k = i + 1; k < len; k++) {
                if (rating[k] > rating[i])
                    rightGreat++;
                else if (rating[k] < rating[i])
                    rightSmall++;
            }
            count += leftSmall * rightGreat + leftGreat * rightSmall;
        }
        return count;
    }

    public static void main(String[] args) {
        _1395_Count_Number_of_Teams test = new _1395_Count_Number_of_Teams();
        System.out.println(test.numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(test.numTeams(new int[]{2, 1, 3}));
        System.out.println(test.numTeams(new int[]{1, 2, 3, 4}));
    }
}
