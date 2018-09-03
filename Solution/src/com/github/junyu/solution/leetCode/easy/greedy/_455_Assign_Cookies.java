package com.github.junyu.solution.leetCode.easy.greedy;

import java.util.Arrays;

public class _455_Assign_Cookies {

    /*Assume you are an awesome parent and want to give your children some cookies.
    But, you should give each child at most one cookie. Each child i has a greed factor gi,
    which is the minimum size of a cookie that the child will be content with; and each cookie
    j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
    Your goal is to maximize the number of your content children and output the maximum number.

    Note:
    You may assume the greed factor is always positive.
    You cannot assign more than one cookie to one child.

    Example 1:
    Input: [1,2,3], [1,1]

    Output: 1

    Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
    And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
    You need to output 1.
    Example 2:
    Input: [1,2], [1,2,3]

    Output: 2

    Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
    You have 3 cookies and their sizes are big enough to gratify all of the children,
    You need to output 2.*/

    /**
     * 分饼干，假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
     * 但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
     * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
     * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * 解决这题的关键在于，始终是以饼干的大小为依据，先对两个数组进行一次排序，然后每次取出一个饼干，看看是否有g[p1]小于s[i]的，满足则对p1进行++，指向下一个
     * 小孩，如果不满足，那就看下一个饼干，是否满足g[p1]，总体策略就是以最小的代价满足需求最小的孩子。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0;
        for (int i = 0; i < s.length && p1 < g.length; i++) {
            if (s[i] >= g[p1]) {
                p1++;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
       int g[] =  {1,2,3} ;int s [] =  {1,1};
//        int g[] = {1, 2};
//        int s[] = {1, 2, 3};
        System.out.println(new _455_Assign_Cookies().findContentChildren(g, s));
    }

}
