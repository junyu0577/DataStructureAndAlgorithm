package com.github.junyu.solution.leetCode.easy.array;

public class _1732_Find_the_Highest_Altitude {

    /*
    There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
    The biker starts his trip on point 0 with altitude equal 0.

    You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​
    ​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.



            Example 1:

    Input: gain = [-5,1,5,0,-7]
    Output: 1
    Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
    Example 2:

    Input: gain = [-4,-3,-2,-1,4,3,2]
    Output: 0
    Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.


    Constraints:

    n == gain.length
    1 <= n <= 100
            -100 <= gain[i] <= 100
    */

    /**
     * 找到最高海波
     * 定义cur依次与gain的每一个元素进行累加，记录中间最大的cur并返回。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Highest Altitude.
     * Memory Usage: 36.6 MB, less than 48.58% of Java online submissions for Find the Highest Altitude.
     *
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int cur = 0;
        for (int i : gain){
            cur += i;
            ans = Math.max(ans,cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        _1732_Find_the_Highest_Altitude test = new _1732_Find_the_Highest_Altitude();
        System.out.println(test.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(test.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

}
