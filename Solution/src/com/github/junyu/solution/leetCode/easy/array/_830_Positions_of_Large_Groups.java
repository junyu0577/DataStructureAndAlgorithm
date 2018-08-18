package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830_Positions_of_Large_Groups {

/*

    In a string S of lowercase letters, these letters form consecutive groups of the same character.

    For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

    Call a group large if it has 3 or more characters.  We would like the starting and ending
    positions of every large group.

    The final answer should be in lexicographic order.



    Example 1:

    Input: "abbxxxxzzy"
    Output: [[3,6]]
    Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
    Example 2:

    Input: "abc"
    Output: []
    Explanation: We have "a","b" and "c" but no large group.
    Example 3:

    Input: "abcdddeeeeaabbbcd"
    Output: [[3,5],[6,9],[12,14]]


    Note:  1 <= S.length <= 1000
*/

    /**
     * 找到所有相同字符且长度大于等于3的子串
     * 定义一个指针指向头部，然后从第二个元素开始不断的与left指针指向的元素进行比较，如果当前的元素和left不同，那么
     * 就需要查看当前的索引与left索引的差是否大于等于3，大于等于3就满足子串条件，从left到i-1就是子串的开始位置和结束位数。
     * 最后还需要维护一下left，让left移至i的位置。
     * 最后的一个判断是防止最后几个元素满足子串的条件，比如字符串aaa，我们的for循环中不会进行最里层的逻辑，因为后续的元素都是相同。
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S.length() < 3)
            return res;
        char cs[] = S.toCharArray();
        int left = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != cs[left]) {
                if (i - left >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(i - 1);
                    res.add((list));
                }

                left = i;
            }
        }
        if (cs.length - left >= 3)
            res.add(new ArrayList<>(Arrays.asList(left, cs.length - 1)));
        return res;
    }

    public static void main(String[] args) {
//        String s = "abbxxxxzzy";
//        String s = "abc";
//        String s = "aaa";
        String s = "abcdddeeeeaabbbcd";
        _830_Positions_of_Large_Groups positions_of_large_groups = new _830_Positions_of_Large_Groups();
        List<List<Integer>> res = positions_of_large_groups.largeGroupPositions(s);
        for (int i = 0; i < res.size(); i++) {
            System.out.println((res.get(i)));
        }
    }


}
