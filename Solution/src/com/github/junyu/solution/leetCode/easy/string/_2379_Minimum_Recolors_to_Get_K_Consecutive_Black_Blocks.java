package com.github.junyu.solution.leetCode.easy.string;

public class _2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {

    /*
    You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

    You are also given an integer k, which is the desired number of consecutive black blocks.

    In one operation, you can recolor a white block such that it becomes a black block.

    Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.



    Example 1:

    Input: blocks = "WBBWWBBWBW", k = 7
    Output: 3
    Explanation:
    One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
    so that blocks = "BBBBBBBWBW".
    It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
            Therefore, we return 3.
    Example 2:

    Input: blocks = "WBWBBBW", k = 2
    Output: 0
    Explanation:
    No changes need to be made, since 2 consecutive black blocks already exist.
            Therefore, we return 0.


    Constraints:

    n == blocks.length
    1 <= n <= 100
    blocks[i] is either 'W' or 'B'.
            1 <= k <= n
    */


    /**
     * 得到 K 个黑块的最少涂色次数
     * 窗口滑动算法
     *
     * 定义左右指针，右指针开始往后扫，扫到W就累加step，然后判断当前B的数量是否满足k，不满足则继续向后扫。
     * 满足就记录当前的step（比较最小值）。此时要开始缩小范围让left让后扫，不过扫之前先判断指向的是否是W，如果
     * 是还需要减去之间增加的step。
     *
     * Runtime: 1 ms, faster than 86.43% of Java online submissions for Minimum Recolors to Get K Consecutive Black Blocks.
     * Memory Usage: 42.1 MB, less than 24.06% of Java online submissions for Minimum Recolors to Get K Consecutive Black Blocks.
     *
     * @param blocks
     * @param k
     * @return
     */
    public int minimumRecolors(String blocks, int k) {
        int left = 0, right = 0, len = blocks.length();
        int curCount = 0;
        int step = 0;
        int ans = Integer.MAX_VALUE;
        while (right < len && left <= len - k) {
            char c = blocks.charAt(right);
            curCount++;
            if (c != 'B') {
                step++;
            }
            if (curCount == k) {
                curCount--;
                ans = Math.min(ans, step);
                if (blocks.charAt(left) == 'W')
                    step--;

                left++;
            }
            right++;

        }
        return ans;
    }

    public static void main(String[] args) {
        _2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks test = new _2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks();
        System.out.println(test.minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(test.minimumRecolors("WBWBBBW", 2));
    }
}
