package com.github.junyu.solution.leetCode.easy.string;


public class _1047_Remove_All_Adjacent_Duplicates_In_String {

    /*
    Given a string S of lowercase letters, a duplicate removal consists of choosing 
    two adjacent and equal letters, and removing them.

    We repeatedly make duplicate removals on S until we no longer can.

    Return the final string after all such duplicate removals have been made.
    It is guaranteed the answer is unique.
            
    Example 1:

    Input: "abbaca"
    Output: "ca"
    Explanation:
    For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, 
    and this is the only possible move. 
    The result of this move is that the string is "aaca", 
    of which only "aa" is possible, so the final string is "ca".


    Note:

            1 <= S.length <= 20000
    S consists only of English lowercase letters.
    */

    /**
     * 删除相邻重复的元素，每次删除后都需要重新再遍历数字符串，如果有重复继续删除
     * 最先想到的这个办法就是将字符串放入StringBuild中，不断的循环它，比较相邻的元素，如果找到了就
     * 删除，然后重置left和right变量；如果没找到就比较下一对元素。
     *
     * @param S
     * @return
     */
//    public String removeDuplicates(String S) {
//        if (S.length() == 1)
//            return S;
//
//        StringBuilder sb = new StringBuilder(S);
//        int left = 0;
//        int right = 1;
//        while (true) {
//            if (sb.length() == 1)
//                break;
//
//            char leftChar = sb.charAt(left);
//            char rightChar = sb.charAt(right);
//            if (leftChar==rightChar){
//                sb.deleteCharAt(right);
//                sb.deleteCharAt(left);
//                left = 0;
//                right = 1;
//            } else {
//                left = right;
//                right+=1;
//            }
//
//            if (right>sb.length()-1)
//                break;
//
//        }
//        return sb.toString();
//    }


    /**
     * 开辟一段空间用来保存当前循环到的字符，并设置一个变量用来记录这段空间的起始位置。
     * 每次循环时，发现重复的元素，就将起始位置-1；如果没有发现重复的，就将当前元素保存到ans中，
     * 并递增起始位置。如果整个字符串中都没有相同的元素，那么这个index就是字符串的长度。
     * 时间复杂度为O(n)
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        char cs[] = S.toCharArray();
        int len = cs.length;
        char ans [] = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (index>0 && ans[index-1] == cs[i]){
                index--;
            }else {
                ans[index] = cs[i];
                index++;
            }
        }
        return new String(ans,0,index);
    }

    public static void main(String[] args) {
        _1047_Remove_All_Adjacent_Duplicates_In_String remove_all_adjacent_duplicates_in_string = new _1047_Remove_All_Adjacent_Duplicates_In_String();
        System.out.println(remove_all_adjacent_duplicates_in_string.removeDuplicates("abbaca"));
        System.out.println(remove_all_adjacent_duplicates_in_string.removeDuplicates("abcd"));
    }

}
