package com.github.junyu.solution.leetCode.easy.math;

import java.util.Arrays;

public class _942_DI_String_Match {

    /*Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

            Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

    If S[i] == "I", then A[i] < A[i+1]
    If S[i] == "D", then A[i] > A[i+1]


    Example 1:

    Input: "IDID"
    Output: [0,4,1,3,2]
    Example 2:

    Input: "III"
    Output: [0,1,2,3]
    Example 3:

    Input: "DDI"
    Output: [3,2,0,1]


    Note:

            1 <= S.length <= 10000
    S only contains characters "I" or "D".*/

    /**
     * 升序升序字符串匹配
     * 遍历字符串的每个字符，如果当前是I，表示下个字母是升序，D则相反。
     * 那么可以定义两个变量left为最小值，right为最大值。每次遇到I说明下一个必定是大于当前的，所以直接取当前可用的最大值
     * right，然后对right进行-1操作。遇到D就取left，并对left进行+1处理。
     * 最后由于数组的内容长度比字符串长1位，还需要给数组的最后一个元素添加left。
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int left = 0;
        int right = S.length();

        int res [] = new int[S.length()+1];
        int i = 0;
        while (i<S.length()){
            if ('D' == S.charAt(i)){
                res[i] = right--;
            } else {
                res[i] = left++;
            }
            i++;
        }

        res[i] = left;

        return res;

    }

    public static void main(String [] args) {
        _942_DI_String_Match di_string_match = new _942_DI_String_Match();
        System.out.println(Arrays.toString(di_string_match.diStringMatch("IDID")));
        System.out.println(Arrays.toString(di_string_match.diStringMatch("III")));
        System.out.println(Arrays.toString(di_string_match.diStringMatch("DDI")));
        System.out.println(Arrays.toString(di_string_match.diStringMatch("D")));
        System.out.println(Arrays.toString(di_string_match.diStringMatch("I")));
    }


}
