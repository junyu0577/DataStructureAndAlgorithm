package com.github.junyu.solution.leetCode.easy.string;

public class _1422_Maximum_Score_After_Splitting_a_String {


    /*Given a string s of zeros and ones, return the maximum score after splitting the string
    into two non-empty substrings (i.e. left substring and right substring).

    The score after splitting a string is the number of zeros in the left substring plus the
    number of ones in the right substring.

    Example 1:

    Input: s = "011101"
    Output: 5
    Explanation:
    All possible ways of splitting s into two non-empty substrings are:
    left = "0" and right = "11101", score = 1 + 4 = 5
    left = "01" and right = "1101", score = 1 + 3 = 4
    left = "011" and right = "101", score = 1 + 2 = 3
    left = "0111" and right = "01", score = 1 + 1 = 2
    left = "01110" and right = "1", score = 2 + 1 = 3
    Example 2:

    Input: s = "00111"
    Output: 5
    Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
    Example 3:

    Input: s = "1111"
    Output: 3

    Constraints:

    2 <= s.length <= 500
    The string s consists of characters '0' and '1' only.*/

    /**
     * 解法二:首先统计字符串中1的数量，然后进行遍历字符串，此时当前的索引就是分割点，如果第一个元素为0，那么此时，0的数量就增加了，而1的则保持不变。
     * 然后将0与1数量的和与max进行比较，取最大值。如果遇到的元素是1，那么需要将1的数量进行递减，每次循环都重新查看整体的数量和，以此保证能够获取最大值。
     * 时间复杂度O(n)
     * @param s
     * @return
     */
    public int maxScore(String s) {
        int max = 0;

        int zeroCount = 0;
        int oneCount = 0;

        char cs[] = s.toCharArray();
        for (char c : cs) {
            if (c == '1')
                oneCount++;
        }

        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == '0')
                zeroCount++;
            else
                oneCount--;

            max = Math.max(max, zeroCount + oneCount);
        }

        return max;
    }

//    /**
//     * 分割字符串，左边的字符串统计0的数量，右边的字符串统计1的数量，求分割后数量最多的值
//     * 解法一：通过定义一个指针，从第一个字符一直挪到倒数第二个字符，指针所指的包括自身在内的左部统计0的数量，右边统计1的数量，
//     * 每次移动指针后进行左右的数量统计，将结果与max进行比较取最大值。
//     * 时间复杂度为O(n^2)
//     *
//     * @param s
//     * @return
//     */
//    public int maxScore(String s) {
//        int point = 0;
//        int max = 0;
//        char [] cs = s.toCharArray();
//        while (point<cs.length-1){
//            int curMax = 0;
//            for (int i=0;i<=point;i++){
//                if (cs[i]=='0')
//                    curMax++;
//            }
//
//            for (int i=point+1;i<cs.length;i++){
//                if (cs[i]=='1')
//                    curMax++;
//            }
//
//            max = Math.max(curMax,max);
//            point++;
//        }
//
//        return max;
//    }
    public static void main(String[] args) {
        _1422_Maximum_Score_After_Splitting_a_String test = new _1422_Maximum_Score_After_Splitting_a_String();
        System.out.println(test.maxScore("011101"));
        System.out.println(test.maxScore("00111"));
        System.out.println(test.maxScore("1111"));
        System.out.println(test.maxScore("00"));
        System.out.println(test.maxScore("01111"));
    }
}
