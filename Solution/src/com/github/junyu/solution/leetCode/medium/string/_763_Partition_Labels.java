package com.github.junyu.solution.leetCode.medium.string;

import java.util.ArrayList;
import java.util.List;

public class _763_Partition_Labels {

  /*  A string S of lowercase letters is given. We want to partition this string into as
    many parts as possible so that each letter appears in at most one part, and return a
    list of integers representing the size of these parts.

    Example 1:
    Input: S = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
    Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.
*/

    /**
     * 将字符串拆分成多个label，相同的字母必须在一个标签中
     * 先统计每个字母最后出现的位置，然后开始遍历整个字符串。定义两个指针start指向子串头部，last指向子串尾部。
     * 如果每次遍历到的元素的最后所在位置大于last位置，那么更新last的值。
     * 当遍历的索引i与last相等时，说明已经找到一个要拆分的label，计算长度，然后在更新start的位置指向i+1
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        int [] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i)-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(hash[S.charAt(i)-'a'],last);
            if (last == i) {
                res.add(last-start+1);
                start = i+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _763_Partition_Labels partition_labels = new _763_Partition_Labels();
        System.out.println(partition_labels.partitionLabels("ababcbacadefegdehijhklij"));
    }

}
