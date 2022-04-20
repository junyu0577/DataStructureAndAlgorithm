package com.github.junyu.solution.leetCode.easy.string;

import java.util.Arrays;

public class _2138_Divide_a_String_Into_Groups_of_Size_k {

    /*
    A string s can be partitioned into groups of size k using the following procedure:

    The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each character can be a part of exactly one group.
    For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
    Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.

    Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.



    Example 1:

    Input: s = "abcdefghi", k = 3, fill = "x"
    Output: ["abc","def","ghi"]
    Explanation:
    The first 3 characters "abc" form the first group.
    The next 3 characters "def" form the second group.
    The last 3 characters "ghi" form the third group.
    Since all groups can be completely filled by characters from the string, we do not need to use fill.
            Thus, the groups formed are "abc", "def", and "ghi".
    Example 2:

    Input: s = "abcdefghij", k = 3, fill = "x"
    Output: ["abc","def","ghi","jxx"]
    Explanation:
    Similar to the previous example, we are forming the first three groups "abc", "def", and "ghi".
    For the last group, we can only use the character 'j' from the string. To complete this group, we add 'x' twice.
            Thus, the 4 groups formed are "abc", "def", "ghi", and "jxx".


    Constraints:

            1 <= s.length <= 100
    s consists of lowercase English letters only.
    1 <= k <= 100
    fill is a lowercase English letter.

    */

    /**
     * 将字符串拆分为若干长度为 k 的组
     *
     * Runtime: 1 ms, faster than 98.78% of Java online submissions for Divide a String Into Groups of Size k.
     * Memory Usage: 40.7 MB, less than 99.19% of Java online submissions for Divide a String Into Groups of Size k.
     *
     * 先根据k计算出需要切分的个数，如果除不尽需要算出余数。定义数组的长度为切分的个数（有余数则为切分数+1）。
     * 最后记得如果除不尽的情况还要补上填充字符，填充的数量为（k-余数）
     *
     * @param s
     * @param k
     * @param fill
     * @return
     */
    public String[] divideString(String s, int k, char fill) {
        int remain = s.length()%k;
        int count = s.length()/k;
        int ansLen = count;

        if (remain!=0){
            ansLen+=1;
        }

        String ans [] = new String[ansLen];

        int start = 0;
        for (int i=0;i<count;i++){
            ans[i] = s.substring(start,start+k);
            start+=k;
        }

        if (remain!=0){
            StringBuilder last = new StringBuilder();
            last.append(s.substring(start));
           for (int i=0;i<k-remain;i++){
               last.append(fill);
           }
            ans[ans.length-1] = last.toString();
        }

        return ans;
    }

    public static void main(String [] args) {
        _2138_Divide_a_String_Into_Groups_of_Size_k test = new _2138_Divide_a_String_Into_Groups_of_Size_k();
        System.out.println(Arrays.toString(test.divideString("abcdefghi",3,'x')));
        System.out.println(Arrays.toString(test.divideString("abcdefghij",3,'x')));
    }
}
