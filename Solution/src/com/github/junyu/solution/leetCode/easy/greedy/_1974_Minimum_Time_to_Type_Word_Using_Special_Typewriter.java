package com.github.junyu.solution.leetCode.easy.greedy;

public class _1974_Minimum_Time_to_Type_Word_Using_Special_Typewriter {

    /*
    There is a special typewriter with lowercase English letters 'a' to 'z'
    arranged in a circle with a pointer. A character can only be typed
    if the pointer is pointing to that character. The pointer is initially
    pointing to the character 'a'.


    Each second, you may perform one of the following operations:

    Move the pointer one character counterclockwise or clockwise.
    Type the character the pointer is currently on.
    Given a string word, return the minimum number of seconds to type out
     the characters in word.



    Example 1:

    Input: word = "abc"
    Output: 5

    Explanation:
    The characters are printed as follows:
            - Type the character 'a' in 1 second since the pointer is initially on 'a'.
            - Move the pointer clockwise to 'b' in 1 second.
            - Type the character 'b' in 1 second.
            - Move the pointer clockwise to 'c' in 1 second.
            - Type the character 'c' in 1 second.

    Example 2:

    Input: word = "bza"
    Output: 7
    Explanation:
    The characters are printed as follows:
            - Move the pointer clockwise to 'b' in 1 second.
            - Type the character 'b' in 1 second.
            - Move the pointer counterclockwise to 'z' in 2 seconds.
            - Type the character 'z' in 1 second.
            - Move the pointer clockwise to 'a' in 1 second.
            - Type the character 'a' in 1 second.

    Example 3:

    Input: word = "zjpc"
    Output: 34
    Explanation:
    The characters are printed as follows:
            - Move the pointer counterclockwise to 'z' in 1 second.
            - Type the character 'z' in 1 second.
            - Move the pointer clockwise to 'j' in 10 seconds.
            - Type the character 'j' in 1 second.
            - Move the pointer clockwise to 'p' in 6 seconds.
            - Type the character 'p' in 1 second.
            - Move the pointer counterclockwise to 'c' in 13 seconds.
            - Type the character 'c' in 1 second.


    Constraints:

            1 <= word.length <= 100
    word consists of lowercase English letters.
*/

    /**
     * 使用特殊打字机键入单词的最少时间
     * 每一秒钟，你可以执行以下操作之一：
     *      将指针 顺时针 或者 逆时针 移动一个字符。
     *      键入指针 当前 指向的字符。
     *
     * 定义cur用于记录指针位置，然后遍历字符，如果指针指向的小于等于当前的，那么我们就可以先进行顺时针走，
     * 接着用26-顺时针的步数可以得出逆时针走的步数。累加上最小的步数，然后将当前的指针指向当前元素。如果
     * 指针指向的大于当前元素，那么就先进行逆时针行走。其他同理。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Time to Type Word Using Special Typewriter.
     * Memory Usage: 38.5 MB, less than 52.18% of Java online submissions for Minimum Time to Type Word Using Special Typewriter.
     * @param word
     * @return
     */
    public int minTimeToType(String word) {
        int ans = 0;
        char cur = 'a';
        for (char c : word.toCharArray()) {
            if (c >= cur) {
                int dif = c - cur;//顺时针
                ans += Math.min(dif, 26 - dif);//与逆时针做比较取步数少的
            } else {
                int dif = cur-c;//逆时针
                ans+= Math.min(dif,26-dif);
            }
            cur = c;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1974_Minimum_Time_to_Type_Word_Using_Special_Typewriter test = new _1974_Minimum_Time_to_Type_Word_Using_Special_Typewriter();
        System.out.println(test.minTimeToType("abc"));
        System.out.println(test.minTimeToType("bza"));
        System.out.println(test.minTimeToType("zjpc"));
    }
}
