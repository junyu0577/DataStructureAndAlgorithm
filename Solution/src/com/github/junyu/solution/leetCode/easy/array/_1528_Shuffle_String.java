package com.github.junyu.solution.leetCode.easy.array;

public class _1528_Shuffle_String {

    /*Given a string s and an integer array indices of the same length.

    The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

    Return the shuffled string.

    Example 1:


    Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
    Output: "leetcode"
    Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
    Example 2:

    Input: s = "abc", indices = [0,1,2]
    Output: "abc"
    Explanation: After shuffling, each character remains in its position.
            Example 3:

    Input: s = "aiohn", indices = [3,1,4,2,0]
    Output: "nihao"
    Example 4:

    Input: s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
    Output: "arigatou"
    Example 5:

    Input: s = "art", indices = [1,0,2]
    Output: "rat"


    Constraints:

    s.length == indices.length == n
    1 <= n <= 100
    s contains only lower-case English letters.
            0 <= indices[i] < n
    All values of indices are unique (i.e. indices is a permutation of the integers from 0 to n - 1).*/

    /**
     * 重新排列字符串
     * 思路：定义等s等长的数组用来存放重排后的元素。indices[i]为要存放的位置，s.charAt(i)为当前要存放的字符。
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        char [] ans = new char[indices.length];
        for (int i=0;i<indices.length;i++){
            ans[indices[i]] = s.charAt(i);
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        _1528_Shuffle_String test = new _1528_Shuffle_String();
        System.out.println(test.restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3}));
        System.out.println(test.restoreString("abc",new int[]{0,1,2}));
        System.out.println(test.restoreString("aiohn",new int[]{3,1,4,2,0}));
        System.out.println(test.restoreString("aaiougrt",new int[]{4,0,2,6,7,3,1,5}));
        System.out.println(test.restoreString("art",new int[]{1,0,2}));
    }
}
