package com.github.junyu.solution.interview.easy;

public class _0101 {

    /*实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

    示例 1：

    输入: s = "leetcode"
    输出: false
    示例 2：

    输入: s = "abc"
    输出: true
    限制：

            0 <= len(s) <= 100
    如果你不使用额外的数据结构，会很加分。*/

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同
     * 思路：借用数组统一出现的字符次数来判断是否有重复
     * @param astr
     * @return
     */
//    public boolean isUnique(String astr) {
//        int [] count = new int[26];
//        for (char c : astr.toCharArray())
//            count[c-'a']++;
//
//        for (int i :count){
//            if (i>1)
//                return false;
//        }
//
//        return true;
//    }


    /**
     * 判断同一个字符最先出现的和最后出现的位置是否相同，如果不同则说明有重复的元素
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        for (char c : astr.toCharArray()) {
            if (astr.indexOf(c) != astr.lastIndexOf(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _0101 test = new _0101();
        System.out.println(test.isUnique("leetcode"));
        System.out.println(test.isUnique("abc"));
    }
}
