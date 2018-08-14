package com.github.junyu.solution.leetCode.easy.hashTable;

public class _771_Jewels_and_Stones {

/*
    You're given strings J representing the types of stones that are jewels,
    and S representing the stones you have.  Each character in S is a type of stone you have.
    You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct, and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".

    Example 1:

    Input: J = "aA", S = "aAAbbbb"
    Output: 3
    Example 2:

    Input: J = "z", S = "ZZ"
    Output: 0
    Note:

    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.
    */

//    /**
//     * J中的字母在S中出现的次数
//     * 建立两个长度为26的数组，里面存放J中的字符在S里出现的字数，大小写分开放
//     * 最后遍历两个数组求sum就得到解了。
//     *
//     * @param J
//     * @param S
//     * @return
//     */
//    public int numJewelsInStones(String J, String S) {
//        if (J == null || J.length() == 0 || S == null || S.length() == 0)
//            return 0;
//
//        int upper[] = new int[26];
//        int lower[] = new int[26];
//
//
//        for (int j = 0; j < J.length(); j++) {
//            for (int i = 0; i < S.length(); i++) {
//                if (S.charAt(i) == J.charAt(j)){
//                    if (S.charAt(i)>='A' && S.charAt(i)<='Z')
//                        upper['Z' - S.charAt(i)]++;
//                    else
//                        lower['z' - S.charAt(i)]++;
//                }
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < lower.length; i++)
//            sum += lower[i];
//        for (int i = 0; i < upper.length; i++)
//            sum += upper[i];
//
//        return sum;
//    }


    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0)
            return 0;

        int count = 0;
        for (char j : J.toCharArray()){
            for (char s : S.toCharArray()){
                if (j==s)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
//        String J = "z", S = "ZZ";
        _771_Jewels_and_Stones jewels_and_stones = new _771_Jewels_and_Stones();
        System.out.println(jewels_and_stones.numJewelsInStones(J, S));
    }

}
