package com.github.junyu.solution.leetCode.easy.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class _1029_Two_City_Scheduling {

    /*
    There are 2N people a company is planning to interview. The cost of flying the i-th
    person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

    Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.



    Example 1:

    Input: [[10,20],[30,200],[400,50],[30,20]]
    Output: 110
    Explanation:
    The first person goes to city A for a cost of 10.
    The second person goes to city A for a cost of 30.
    The third person goes to city B for a cost of 50.
    The fourth person goes to city B for a cost of 20.

    The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.


    Note:

            1 <= costs.length <= 100
    It is guaranteed that costs.length is even.
    1 <= costs[i][0], costs[i][1] <= 1000
    */

    /**
     * 求N个人最少的花费到达一半城市
     * 根据题意可以推出，需要以最小的花费达到一半的城市。
     * 那么先对数组做一次排序，每个人到达一个城市的权重为（costs[i][0]-costs[i][1]），以这个权重进行
     * 升序。
     * 然后让前一半的人去A城市，后一半的人去B城市
     *
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });

        int ans = 0;
        int half = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            if (i < half)
                ans += costs[i][0];
            else
                ans += costs[i][1];

        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(new _1029_Two_City_Scheduling().twoCitySchedCost(arr));
    }


}
